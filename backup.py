@dataclass
class ExplicitCurriculumStage(CurriculumStage):
    """A curriculum stage in which all tasks are explicitly listed, and sampled from according to previous success."""
    task_fn: Optional[Callable[[list[str]], list[LDBASequence]]]

    eps_task_fn: Optional[Callable[[list[str]], list[LDBASequence]]] = None
    temperature: float = 0.4
    _tasks: list[LDBASequence] | None = None
    _task_success: dict[LDBASequence, float] = field(default_factory=dict)
    roll_avg_alpha: float = 0.2
    smooth_const: float = 9.0
    first_update: bool = True
    task_count: int = 0
    print_once: bool = True

    def sample(self, propositions: list[str]) -> LDBASequence:
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
        self.task_count += 1
        return self._tasks[index]

    def compute_sampling_prob(self) -> np.ndarray:
        if len(self._task_success) != len(self._tasks):
            raise ValueError('Task success must be available for all tasks')
        success = torch.tensor([self._task_success[t] for t in self._tasks])
        # SUCCESS - MIN
        success = success - torch.min(success)
        probs = torch.nn.functional.softmax(-success / self.temperature, dim=0)
        if self.print_once:
            print('Success:', success)
            print('Probs:', probs)
            self.print_once = False
        return probs.numpy()

    # def update_task_success(self, task_success: dict[LDBASequence, float]) -> None:
    def update_task_success(self, task_success: dict[LDBASequence, float], eval_counts: dict[LDBASequence, int] = None) -> None:
        print('task count:', self.task_count)
        print('Average Count per task:', np.mean(list(eval_counts.values())))
        self.task_count = 0
        self.print_once = True
        if self.first_update:
            self.first_update = False
            for t in self._tasks:
                if t in task_success:
                    self._task_success[t] = task_success[t]
                    print('INIT: ', t, 'SR = ', self._task_success[t])
                else:
                    self._task_success[t] = 0.0
        else:
            # self._task_success.update(task_success)
            # print('Alpha:', self.roll_avg_alpha)
            for t , v in task_success.items():
                if t in self._task_success:
                    # self._task_success[t] = self.roll_avg_alpha * v + (1 - self.roll_avg_alpha) * self._task_success[t]
                    # this_alpha = np.minimum(0.9, self.roll_avg_alpha * np.log2(eval_counts[t] + 1))
                    this_alpha = np.minimum(0.8, (eval_counts[t]/(eval_counts[t] + self.smooth_const)))
                    last_sr = self._task_success[t]
                    self._task_success[t] = this_alpha * v + (1 - this_alpha) * last_sr
                    print(t, 'Last SR = ', last_sr, ' New SR = ', self._task_success[t], ' Eval = ', v, ' this_alpha:', this_alpha, ' count:', eval_counts[t])

            # self.roll_avg_alpha *= 0.9
            # self.roll_avg_alpha = max(0.2, self.roll_avg_alpha)
                


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
    roll_avg_alpha: float = 0.3
    max_giveup_prob: float = 0.5
    smooth_const: float = 5.0
    task_count: int = 0
    # first_update: bool = True

    def sample(self, propositions: list[str]) -> LDBASequence:
        stage = np.random.choice(self.stages, p=self.probs)
        sample_seq = stage.sampler(propositions)
        self.task_count += 1
        if sample_seq in self._task_success:
            this_sr = self._task_success[sample_seq]
            if self.threshold is not None:
                if this_sr >= self.threshold:
                    if np.random.rand() < np.minimum(self.max_giveup_prob, (this_sr-self.threshold) / (1-self.threshold) * 1.5):
                        #sample from _task_success < threshold
                        sample_seq = random.choice([t for t in self._task_success if self._task_success[t] < self.threshold])
                        return sample_seq
            elif this_sr >= 0.7:
                if np.random.rand() < np.minimum(self.max_giveup_prob, (this_sr-0.7) / (1-0.7) * 1.5):
                    #sample from _task_success < 0.7
                    sample_seq = random.choice([t for t in self._task_success if self._task_success[t] < 0.7])
                    return sample_seq

        
        return sample_seq

    # def update_task_success(self, task_success: dict[LDBASequence, float]) -> None:
    def update_task_success(self, task_success: dict[LDBASequence, float], eval_counts: dict[LDBASequence, int] = None) -> None:
        # if self.first_update:
        #     self.first_update = False
        #     pass
        # else:
            # print('Alpha:', self.roll_avg_alpha)
        print('task count:', self.task_count)
        self.task_count = 0
        print('Average Count per task:', np.mean(list(eval_counts.values())))
        for t , v in task_success.items():
            # ALPHA = 0.3*(COUNT)^0.6
            # this_alpha = np.minimum(0.9, self.roll_avg_alpha * np.power(eval_counts[t], 0.6))
            this_alpha = np.minimum(0.8, (eval_counts[t]/(eval_counts[t] + self.smooth_const)))
            if t in self._task_success:
                last_sr = self._task_success[t]
                self._task_success[t] = this_alpha * v + (1 - this_alpha) * last_sr
                print(t, 'Last SR = ', last_sr, ' New SR = ', self._task_success[t], ' Eval = ', v, ' this_alpha:', this_alpha, ' count:', eval_counts[t])
            else:
                self._task_success[t] = this_alpha * v
                print('INIT: ', t, 'SR = ', self._task_success[t], ' Eval = ', v, ' this_alpha:', this_alpha, ' count:', eval_counts[t])