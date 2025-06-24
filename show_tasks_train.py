import pandas as pd
import inspect
from src.sequence.samplers.curriculum import ExplicitCurriculumStage, RandomCurriculumStage, MultiRandomStage, ZONES_CURRICULUM
import sys

class TeeOutput:
    def __init__(self, *files):
        self.files = files

    def write(self, data):
        for f in self.files:
            f.write(data)
            f.flush()  # Ensure real-time writing

    def flush(self):
        for f in self.files:
            f.flush()

# Save output to "output.txt" and still show in terminal
log_file = open("all_RAS_min_curriculum.txt", "w", encoding="utf-8")
sys.stdout = TeeOutput(sys.stdout, log_file)
sys.stderr = TeeOutput(sys.stderr, log_file)  # Optional: capture errors too


def make_safety_gym_env(name: str, render_mode: str | None = None):
    # noinspection PyUnresolvedReferences
    import safety_gymnasium
    from envs.zones.safety_gym_wrapper import SafetyGymWrapper
    from gymnasium.wrappers import FlattenObservation, TimeLimit


    env = safety_gymnasium.make(name, render_mode=render_mode)
    env = SafetyGymWrapper(env)
    env = FlattenObservation(env)
    return env

def get_env_attr(env, attr: str):
    if hasattr(env, attr):
        return getattr(env, attr)
    if hasattr(env, 'env'):
        return getattr(env.unwrapped, attr)
    else:
        raise AttributeError(f'Attribute {attr} not found in env.')

env = make_safety_gym_env('PointLtl2-v0', render_mode=None)
propositions = get_env_attr(env, 'get_propositions')()


pd.set_option('display.max_rows', None)  # Show all rows
pd.set_option('display.max_columns', None)  # Show all columns
pd.set_option('display.max_colwidth', None)  # Prevent text truncation
pd.set_option('display.width', 1000)  # Expand width for better viewing

# # Define a set of example propositions
# propositions = ["p1", "p2", "p3"]

# Store sampled tasks
sampled_tasks = []
stage_count = 0


print('\n' * 5)
# Iterate over all stages in ZONES_CURRICULUM
for stage in ZONES_CURRICULUM.stages:
    if isinstance(stage, ExplicitCurriculumStage):
        # ExplicitCurriculumStage generates tasks using task_fn
        print('stage ', stage_count, ': ', stage)
        depth = stage.task_fn.__closure__[0].cell_contents  # Retrieves the outer function
        print('Sampling method: ', stage.task_fn.__qualname__.split(".")[0], '(depth = ', depth, ')' )

        if stage.task_fn:
            sampled_tasks.extend(stage.task_fn(propositions))
    elif isinstance(stage, RandomCurriculumStage):
        # RandomCurriculumStage samples a task
        print('stage ', stage_count, ': ', stage)
        # print('Sampling method: ', stage.task_fn.__qualname__.split("."))
        sampled_tasks.append(stage.sample(propositions))
    elif isinstance(stage, MultiRandomStage):
        # MultiRandomStage samples from multiple RandomCurriculumStages
        print('stage ', stage_count, ': ', stage)
        for _ in range(30):  # Reduce iterations to avoid memory issues
            sampled_tasks.append(stage.sample(propositions))

    # Convert to DataFrame for better visualization
    df_sampled_tasks = pd.DataFrame({"Sampled Tasks": [str(task) for task in sampled_tasks]})
    sampled_tasks.clear()
    print(df_sampled_tasks)
    print('-' * 50)
    stage_count += 1


