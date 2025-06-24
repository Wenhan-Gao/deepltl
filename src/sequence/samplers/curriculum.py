import random
from abc import ABC, abstractmethod
from dataclasses import dataclass, field
from typing import Literal, Callable, Optional

import numpy as np
import torch

from ltl.automata import LDBASequence
from sequence.samplers.flatworld_sequence_samplers import flatworld_all_reach_tasks, \
    flatworld_sample_reach_avoid, flatworld_sample_reach_stay, flatworld_sample_reach
from sequence.samplers.sequence_samplers import sample_reach_avoid, all_reach_avoid_tasks, all_reach_tasks, \
    all_reach_stay_tasks, sample_reach_stay, debias_sample_reach_stay, all_reach_avoid_stay_tasks


@dataclass
class CurriculumStage(ABC):
    threshold: float | None
    threshold_type: Literal['mean', 'min'] | None

    @abstractmethod
    def sample(self, propositions: list[str]) -> LDBASequence:
        pass

    @abstractmethod
    def update_task_success(self, task_success: dict[LDBASequence, float]) -> None:
        pass


@dataclass
class ExplicitCurriculumStage(CurriculumStage):
    """A curriculum stage in which all tasks are explicitly listed, and sampled from according to previous success."""
    task_fn: Optional[Callable[[list[str]], list[LDBASequence]]]

    eps_task_fn: Optional[Callable[[list[str]], list[LDBASequence]]] = None
    temperature: float = 0.4
    _tasks: list[LDBASequence] | None = None
    _task_success: dict[LDBASequence, float] = field(default_factory=dict)
    roll_avg_alpha: float = 0.7
    task_count: int = 0
    min_alpha: float = 0.3
    first_update: bool = True

    def sample(self, propositions: list[str]) -> LDBASequence:
        self.task_count += 1
        if self._tasks is None:
            self._tasks = []
            if self.task_fn is not None:
                self._tasks += self.task_fn(propositions)
            if self.eps_task_fn is not None:
                self._tasks += self.eps_task_fn(propositions)
        if self.first_update:
            return random.choice(self._tasks)
        probs = self.compute_sampling_prob()
        index = np.random.choice(np.arange(len(self._tasks)), p=probs).item()
        return self._tasks[index]

    def compute_sampling_prob(self) -> np.ndarray:
        if len(self._task_success) != len(self._tasks):
            raise ValueError('Task success must be available for all tasks')
        success = torch.tensor([self._task_success[t] for t in self._tasks])
        probs = torch.nn.functional.softmax(-success / self.temperature, dim=0)
        return probs.numpy()

    # def update_task_success(self, task_success: dict[LDBASequence, float]) -> None:
    def update_task_success(self, task_success: dict[LDBASequence, float], eval_counts: dict[LDBASequence, int] = None) -> None:
        if self.first_update:
            self.first_update = False
            for t in self._tasks:
                if t in task_success:
                    self._task_success[t] = task_success[t]
                else:
                    self._task_success[t] = 0.0
        else:
            # self._task_success.update(task_success)
            print('task count:', self.task_count)
            self.task_count = 0
            print('Alpha:', self.roll_avg_alpha)
            for t , v in task_success.items():
                if t in self._task_success:
                    last_sr = self._task_success[t]
                    self._task_success[t] = self.roll_avg_alpha * v + (1 - self.roll_avg_alpha) * last_sr
                    print(t, 'Last SR = ', last_sr, 'New SR = ', self._task_success[t], 'Eval SR = ', v)

            self.roll_avg_alpha *= 0.9
            self.roll_avg_alpha = max(self.min_alpha, self.roll_avg_alpha)
                


@dataclass
class RandomCurriculumStage(CurriculumStage):
    """A curriculum stage in which tasks are sampled randomly."""
    sampler: Callable[[list[str]], LDBASequence]

    def sample(self, propositions: list[str]) -> LDBASequence:
        return self.sampler(propositions)

    def update_task_success(self, task_success: dict[LDBASequence, float]) -> None:
        pass


@dataclass
class MultiRandomStage(CurriculumStage):
    """A combination of multiple RandomCurriculumStages with associated sampling probabilities."""
    stages: list[RandomCurriculumStage]
    probs: list[float]
    _task_success: dict[LDBASequence, float] = field(default_factory=dict)
    init_alpha: float = 0.7
    roll_avg_alpha: float = init_alpha
    task_count: int = 0
    min_alpha: float = 0.15
    use_roll_avg: bool = False
    # first_update: bool = True

    def sample(self, propositions: list[str]) -> LDBASequence:
        stage = np.random.choice(self.stages, p=self.probs)
        self.task_count += 1
        return stage.sample(propositions)

    # def update_task_success(self, task_success: dict[LDBASequence, float]) -> None:
    def update_task_success(self, task_success: dict[LDBASequence, float], eval_counts: dict[LDBASequence, int] = None) -> None:
        # if self.first_update:
        #     self.first_update = False
        #     pass
        # else:
            print('task count:', self.task_count)
            self.task_count = 0
            for stage in self.stages:
                stage.update_task_success(task_success)
            if self.use_roll_avg == False:
                self._task_success = task_success
                return
            print('Alpha:', self.roll_avg_alpha)
            for t , v in task_success.items():
                if t in self._task_success:
                    last_sr = self._task_success[t]
                    self._task_success[t] = self.roll_avg_alpha * v + (1 - self.roll_avg_alpha) * last_sr
                    print(t, 'Last SR = ', last_sr, 'New SR = ', self._task_success[t], 'Eval SR = ', v)
                else:
                    self._task_success[t] = self.init_alpha * v
                    print('INIT: ', t, 'SR = ', self._task_success[t])

            self.roll_avg_alpha *= 0.9
            self.roll_avg_alpha = max(self.min_alpha, self.roll_avg_alpha)



class Curriculum:
    def __init__(self, stages: list[CurriculumStage]):
        self.stages = stages
        self.stage_index = 0
        self.num_updates = 0
        self.step_count = 0

    @property
    def current_stage(self) -> CurriculumStage:
        return self.stages[self.stage_index]

    @property
    def finished(self) -> bool:
        return self.stage_index >= len(self.stages)

    def sample(self, propositions: list[str]) -> LDBASequence:
        return self.current_stage.sample(propositions)

    # def update_task_success(self, task_success: dict[LDBASequence, float], verbose=False) -> None:
    def update_task_success(self, task_success: dict[LDBASequence, float], eval_counts: dict[LDBASequence, int] = None, verbose=False) -> None:
        if verbose:
                print(f"Stage {self.stage_index} not completed.")
                print(f'MEAN: {np.mean(list(task_success.values()))}, MIN: {np.min(list(task_success.values()))}, THRESHOLD TYPE: {self.current_stage.threshold_type}, THRESHOLD: {self.current_stage.threshold}')
                # print(f"Task success: {task_success}")

        self.step_count += 65536
        self.current_stage.update_task_success(task_success, eval_counts)
        if verbose:
            print('Mean RollAvg:', np.mean(list(self.current_stage._task_success.values())),
                  'Min RollAvg:', np.min(list(self.current_stage._task_success.values())))
            print('Step Count:', self.step_count)
            if self.stage_index < 5 or self.stage_index == 8:
                print('Rolling Average Task Success:', self.current_stage._task_success)
        
        # skip to the final stage
        if self.current_stage.threshold is None:
            if self.step_count > 13500000 and self.stage_index < len(self.stages) - 1:
            # if self.step_count >= 0 and self.stage_index < len(self.stages) - 1:
                self.stage_index = len(self.stages) - 1  # Skip to the end
                print("\n","==" * 30, f"\nStage {self.stage_index - 1} skipped\n", "==" * 30, "\n")
            return
        # if verbose and self.num_updates % 50 == 0:
        

        self.num_updates += 1
        self.num_updates %= 100

        aggr = np.mean if self.current_stage.threshold_type == 'mean' else np.min
        # if aggr(list(task_success.values())) >= self.current_stage.threshold:
        if aggr(list(self.current_stage._task_success.values())) >= self.current_stage.threshold:

            print("\n","==" * 20, f"\nStage {self.stage_index} completed\n", "=" * 20, "\n")
            self.stage_index += 1
       


LETTER_CURRICULUM = Curriculum([
    ExplicitCurriculumStage(
        task_fn=all_reach_avoid_tasks(1),
        temperature=0.1,
        threshold=0.95,
        threshold_type='mean',
    ),
    RandomCurriculumStage(
        sampler=sample_reach_avoid(1, (1, 2), (0, 2)),
        threshold=0.95,
        threshold_type='mean'
    ),
    RandomCurriculumStage(
        sampler=sample_reach_avoid(2, (1, 2), (1, 2)),
        threshold=0.95,
        threshold_type='mean'
    ),
    RandomCurriculumStage(
        sampler=sample_reach_avoid(3, (1, 2), (0, 3)),
        threshold=None,
        threshold_type=None
    ),
])

# Curriculum for DPLTL_EnumRAS_MA
ZONES_CURRICULUM = Curriculum([
    ExplicitCurriculumStage(  # 0
        task_fn=all_reach_tasks(1),
        # temperature=0.5,
        threshold=0.8,
        threshold_type='min',
    ),
    
    # changed threshold to min
    ExplicitCurriculumStage(  # 1
        task_fn=all_reach_tasks(2),
        threshold=0.9,
        threshold_type='min'
    ),
    ExplicitCurriculumStage(  # 2
        task_fn=all_reach_avoid_tasks(1),
        threshold=0.9,
        threshold_type='min'
    ),
    ExplicitCurriculumStage(  # 3
        task_fn=all_reach_avoid_tasks(2),
        threshold=0.8,
        threshold_type='min',
        min_alpha=0.2
    ),
    ExplicitCurriculumStage(  # testing
        # task_fn=all_reach_avoid_stay_tasks(30, (0, 1)),
        task_fn=all_reach_avoid_stay_tasks(30, (0, 0)),
        threshold=0.9,
        threshold_type='min'
    ),
    MultiRandomStage(  # 4
        stages=[
            RandomCurriculumStage(
                sampler=sample_reach_avoid(1, (1, 2), (0, 2)),
                threshold=None,
                threshold_type=None
            ),
            ExplicitCurriculumStage(
                task_fn=all_reach_avoid_stay_tasks(30, (0, 1)),
                threshold=None,
                threshold_type=None
            ),
        ],
        probs=[0.5, 0.5],
        threshold=0.9,
        threshold_type='mean',
        use_roll_avg=True,
    ),
    MultiRandomStage(  # 5
        stages=[
            RandomCurriculumStage(
                sampler=sample_reach_avoid(2, (1, 2), (1, 2)),
                threshold=None,
                threshold_type=None
            ),
            ExplicitCurriculumStage(
                task_fn=all_reach_avoid_stay_tasks(60, (0, 1)),
                threshold=None,
                threshold_type=None
            ),
        ],
        probs=[0.8, 0.2],
        threshold=0.8,
        threshold_type='mean',
        min_alpha=0.3
    ),
    MultiRandomStage(  # 6
        stages=[
            RandomCurriculumStage(
                sampler=sample_reach_avoid(3, (1, 2), (0, 3)),
                threshold=None,
                threshold_type=None
            ),
            ExplicitCurriculumStage(
                task_fn=all_reach_avoid_stay_tasks(60, (0, 2)),
                threshold=None,
                threshold_type=None
            ),
        ],
        probs=[0.8, 0.2],
        threshold=None,
        threshold_type=None
    ),
    ExplicitCurriculumStage(
        task_fn=all_reach_avoid_stay_tasks(60, (0, 2)),
        threshold=None,
        threshold_type=None
    ),
])

## curriculum for DPLTL_EnumRS
# ZONES_CURRICULUM = Curriculum([
#     ExplicitCurriculumStage(  # 0
#         task_fn=all_reach_tasks(1),
#         temperature=0.5,
#         threshold=0.8,
#         threshold_type='min',
#     ),
#     ExplicitCurriculumStage(  # 1
#         task_fn=all_reach_tasks(2),
#         threshold=0.95,
#         threshold_type='mean'
#     ),
#     ExplicitCurriculumStage(  # 2
#         task_fn=all_reach_avoid_tasks(1),
#         threshold=0.95,
#         threshold_type='mean'
#     ),
#     ExplicitCurriculumStage(  # 3
#         task_fn=all_reach_avoid_tasks(2),
#         threshold=0.9,
#         threshold_type='mean'
#     ),
#     ExplicitCurriculumStage(  # testing
#         # task_fn=all_reach_avoid_stay_tasks(30, (0, 1)),
#         task_fn=all_reach_avoid_stay_tasks(30, (0, 0)),
#         threshold=0.9,
#         threshold_type='min'
#     ),
#     MultiRandomStage(  # 4
#         stages=[
#             RandomCurriculumStage(
#                 sampler=sample_reach_avoid(1, (1, 2), (0, 2)),
#                 threshold=None,
#                 threshold_type=None
#             ),
#             RandomCurriculumStage(
#                 sampler=sample_reach_stay(30, (0, 1)),
#                 threshold=None,
#                 threshold_type=None
#             ),
#         ],
#         probs=[0.5, 0.5],
#         threshold=0.9,
#         threshold_type='mean'
#     ),
#     MultiRandomStage(  # 5
#         stages=[
#             RandomCurriculumStage(
#                 sampler=sample_reach_avoid(2, (1, 2), (1, 2)),
#                 threshold=None,
#                 threshold_type=None
#             ),
#             RandomCurriculumStage(
#                 sampler=sample_reach_stay(60, (0, 1)),
#                 threshold=None,
#                 threshold_type=None
#             ),
#         ],
#         probs=[0.8, 0.2],
#         threshold=0.9,
#         threshold_type='mean'
#     ),
#     MultiRandomStage(  # 6
#         stages=[
#             RandomCurriculumStage(
#                 sampler=sample_reach_avoid(3, (1, 2), (0, 3)),
#                 threshold=None,
#                 threshold_type=None
#             ),
#             RandomCurriculumStage(
#                 sampler=sample_reach_stay(60, (0, 2)),
#                 threshold=None,
#                 threshold_type=None
#             ),
#         ],
#         probs=[0.8, 0.2],
#         threshold=None,
#         threshold_type=None
#     ),
# ])

FLATWORLD_CURRICULUM = Curriculum([
    MultiRandomStage(  # 0
        stages=[
            RandomCurriculumStage(
                sampler=flatworld_sample_reach_avoid((1, 2), 1, 1),
                threshold=None,
                threshold_type=None
            ),
            RandomCurriculumStage(
                sampler=flatworld_sample_reach((1, 2)),
                threshold=None,
                threshold_type=None
            ),
        ],
        probs=[0.6, 0.4],
        threshold=0.8,
        threshold_type='mean'
    ),
    RandomCurriculumStage(
        sampler=flatworld_sample_reach_avoid((1, 2), (1, 2), (0, 2)),
        threshold=None,
        threshold_type=None
    ),
])
