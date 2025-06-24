import numpy as np
import torch

import preprocessing
from model.model import Model
from sequence.search import SequenceSearch
from collections import defaultdict


class Agent:
    def __init__(self, model: Model, search: SequenceSearch, propositions: set[str], verbose=False):
        self.model = model
        self.search = search
        self.propositions = propositions
        self.verbose = verbose
        self.sequence = None
        # self.sequence_counts = defaultdict(int)
        # self.sequence_counts_eps = defaultdict(int)
        self.sequence_counts_by_len = defaultdict(lambda: defaultdict(int))

    def reset(self):
        self.sequence = None

    def get_action(self, obs, info, deterministic=False) -> np.ndarray:
        if 'ldba_state_changed' in info or self.sequence is None:
            self.sequence = self.search(obs['ldba'], obs['ldba_state'], obs)
            # new_reach = [x for x in self.sequence[0][0] if not any([y for y in self.sequence[0][1] if y.get_true_propositions().issubset(x.get_true_propositions())])]
            # self.sequence = [(frozenset(new_reach), self.sequence[0][1]), *self.sequence[1:]]
            dont_print = False
            # if self.verbose:
            if True:
                print(f'Selected sequence: {self.sequence}')
                seq_str = str(self.sequence)
                seq_len = len(self.sequence)

                self.sequence_counts_by_len[seq_len][seq_str] += 1

                for length, seqs in sorted(self.sequence_counts_by_len.items(), reverse=True):
                    total = sum(seqs.values())
                    print(f"\n=== Length {length} ===")
                    for seq, count in sorted(seqs.items(), key=lambda x: -x[1]):
                        prob = count / total
                        print(f"{seq} → P = {prob:.3f} ({count}/{total})")

                print("\n" * 2)

        assert self.sequence is not None
        obs['goal'] = self.sequence
        return self.forward(obs, deterministic)

    def forward(self, obs, deterministic=False) -> np.ndarray:
        if not (isinstance(obs, list) or isinstance(obs, tuple)):
            obs = [obs]
        preprocessed = preprocessing.preprocess_obss(obs, self.propositions)
        with torch.no_grad():
            dist, value = self.model(preprocessed)
            action = dist.mode if deterministic else dist.sample()
        return action.detach().numpy()
