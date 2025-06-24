import numpy as np
from safety_gymnasium import agents
from safety_gymnasium.assets.geoms import Zones
from safety_gymnasium.tasks.ltl.ltl_base_task import LtlBaseTask


class LtlBiasTest0(LtlBaseTask):
    """
    One zone each of green, yellow, blue, magenta,
    placed at equal radius but non-overlapping in random order.
    """
    def __init__(self, config) -> None:
        print("LTL Bias Test 0")
        # radius at which to place the zones around the agent
        self.zone_radius = config.get('zone_radius', 2.0)
        super().__init__(config=config, zone_size=config.get('zone_size', 0.4))

        for color in ('green', 'yellow', 'blue', 'magenta'):
            print(f"Adding zone of color {color}")
            self._add_geoms(Zones(color=color, size=self.zone_size, num=1))

        self.count = 0
        self.success = 0
        self.max_count = 0

    # def _build_agent(self, agent_name: str) -> None:
    #     """Build the agent and then snap its start pos to a square region."""
    #     # 1) do the normal agent construction
    #     assert hasattr(agents, agent_name), f'agent {agent_name} not found'
    #     agent_cls = getattr(agents, agent_name)
    #     self.agent = agent_cls(random_generator=self.random_generator)

    #     # 2) now override its initial (x,y) to lie in a square
    #     # half‐width of the square from config (default 1.0)
    #     half = self.placements_conf.extents[2] - 0.7 * self.zone_radius
    #     print('-'*20,f"Half: {half}", '-'*20)
    #     x = np.random.uniform(-half, half)
    #     y = np.random.uniform(-half, half)

    #     # 3) write it into the agent’s pos (preserving any extra dims)
    #     self.agent.pos[:2] = np.array([x, y])

    # def _build(self) -> None:
    #     """Build the world."""
    #     # 1) call the base class to build the world
    #     super()._build()

    #     # half‐width of the square
    #     half = self.placements_conf.extents[2] - 1.1 * self.zone_radius
    #     print('-'*20,f"Half: {half}", '-'*20)
    #     x = np.random.uniform(-half, half)
    #     y = np.random.uniform(-half, half)

    #     self.world_info.layout['agent'] = np.array([x, y])
    #     self.world.rebuild(self.world_info.world_config_dict, state=False)
    

    def update_world(self):
        # 1) base random placement (so world_info.layout exists)
        super().update_world()
        self.count += 1
        # 2) agent spawn (x,y)
        agent_xy = self.agent.pos[:2].copy()

        # 3) bounds + buffer
        xmin, ymin, xmax, ymax = self.placements_conf.extents
        buffer = self.zone_size
        def in_bounds(p):
            x, y = p
            # return (xmin + buffer <= x <= xmax - buffer) and (ymin + buffer <= y <= ymax - buffer)
            return (xmin <= x <= xmax) and (ymin <= y <= ymax)

        # 4) which zones we need to place
        layout     = self.world_info.layout
        zone_names = [n for n in layout if 'zone' in n]
        n          = len(zone_names)

        # 5) compute minimum separation angle
        min_angle = 2 * np.arcsin(self.zone_size / self.zone_radius)+ 0.03 * np.pi

        # 6) generate a lattice of angles around the circle
        start = np.random.uniform(0, 2*np.pi)
        count = int(np.floor(2*np.pi / min_angle))
        angles = [(start + k * min_angle) % (2*np.pi) for k in range(count)]

        print('\n'*2, f"Angles: {angles}", '\n'*2)

        # 7) compute candidate points and filter by bounds
        displacement = []
        for θ in angles:
            p = self.zone_radius * np.array([np.cos(θ), np.sin(θ)])
            displacement.append(p)

        # print('\n'*2, f"Displacement: {displacement}", '\n'*2)

        candidates = []
        for θ in angles:
            p = agent_xy + 0.9 * self.zone_radius * np.array([np.cos(θ), np.sin(θ)])
            if in_bounds(p):
                candidates.append(p)

        print('\n'*2, f"Candidates: {candidates}", '\n'*2)

        # 8) need at least n candidates
        if len(candidates) < n:
            # fallback to base behavior
            return

        # 9) randomly pick n of them
        self.success += 1
        print(f"Success: {self.success}", f"Count: {self.count}")
        idxs = np.random.choice(len(candidates), n, replace=False)
        # print(f"Idxs: {idxs}")
        chosen = [candidates[i] for i in idxs]
        # 10) assign to zones
        for name, new_pos in zip(zone_names, chosen):
                self._set_goal(new_pos, name=name)

