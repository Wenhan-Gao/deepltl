import random

import numpy as np
import torch
from matplotlib import pyplot as plt
from tqdm import trange

from envs import make_env
from ltl import FixedSampler
from model.model import build_model
from model.agent import Agent
from config import model_configs
from sequence.search import ExhaustiveSearch
from utils.model_store import ModelStore
from visualize.zones import draw_trajectories

env_name = 'PointLtl2-v0'
# exp = 'deepset'
exp = 'test'
seed = 1

random.seed(seed)
np.random.seed(seed)
torch.random.manual_seed(seed)

# sampler = FixedSampler.partial('GF blue & GF yellow')
sampler = FixedSampler.partial('!(magenta | yellow) U (blue & F green)')
deterministic = True

env = make_env(env_name, sampler, render_mode=None, max_steps=1000)
config = model_configs[env_name]
model_store = ModelStore(env_name, exp, seed, None)
model_store.load_vocab()
training_status = model_store.load_training_status(map_location='cpu')
model = build_model(env, training_status, config)

props = set(env.get_propositions())
search = ExhaustiveSearch(model, props, num_loops=2)
agent = Agent(model, search=search, propositions=props, verbose=False)

num_episodes = 25

trajectories = []
zone_poss = []
envs = [8,9,6,24]

pbar = trange(num_episodes)
# for i in pbar:
for i in envs[:2]:
    env.load_world_info(f'eval_datasets/PointLtl2-v0/worlds/world_info_{i}.pkl')
    obs, info = env.reset(), {}
    agent.reset()
    done = False

    zone_poss.append(env.zone_positions)
    agent_traj = []

    while not done:
        action = agent.get_action(obs, info, deterministic=deterministic)
        action = action.flatten()
        obs, reward, done, info = env.step(action)
        agent_traj.append(env.agent_pos[:2])
        if done:
            trajectories.append(agent_traj)

env.close()

sampler = FixedSampler.partial('GF blue & GF yellow')
deterministic = True

env = make_env(env_name, sampler, render_mode=None, max_steps=1000)
config = model_configs[env_name]
model_store = ModelStore(env_name, exp, seed, None)
model_store.load_vocab()
training_status = model_store.load_training_status(map_location='cpu')
model = build_model(env, training_status, config)

props = set(env.get_propositions())
search = ExhaustiveSearch(model, props, num_loops=2)
agent = Agent(model, search=search, propositions=props, verbose=False)

for i in envs[2:]:
    env.load_world_info(f'eval_datasets/PointLtl2-v0/worlds/world_info_{i}.pkl')
    obs, info = env.reset(), {}
    agent.reset()
    done = False

    zone_poss.append(env.zone_positions)
    agent_traj = []

    while not done:
        action = agent.get_action(obs, info, deterministic=deterministic)
        action = action.flatten()
        obs, reward, done, info = env.step(action)
        agent_traj.append(env.agent_pos[:2])
        if done:
            trajectories.append(agent_traj)
env.close()

# spread out the zones depending on the number of zones
# cols = np.sqrt(len(zone_poss)).astype(int)
# rows = cols if cols ** 2 == len(zone_poss) else cols + 1
cols = 4 if len(zone_poss) > 4 else len(zone_poss)
rows = 1 if len(zone_poss) <= 4 else 2
fig = draw_trajectories(zone_poss, trajectories, cols, rows)
plt.savefig('failed_tasks.png')

plt.show()
