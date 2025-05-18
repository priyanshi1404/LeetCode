class Solution {
    static final int MOD = 1_000_000_007;

    public int colorTheGrid(int m, int n) {
        List<int[]> states = new ArrayList<>();
        generateStates(new int[m], 0, states);

        Map<String, List<String>> compatible = new HashMap<>();
        for (int[] s1 : states) {
            String key1 = Arrays.toString(s1);
            compatible.putIfAbsent(key1, new ArrayList<>());
            for (int[] s2 : states) {
                if (isCompatible(s1, s2)) {
                    compatible.get(key1).add(Arrays.toString(s2));
                }
            }
        }

        Map<String, Integer> dp = new HashMap<>();
        for (int[] state : states) {
            dp.put(Arrays.toString(state), 1);
        }

        for (int col = 1; col < n; col++) {
            Map<String, Integer> newDp = new HashMap<>();
            for (String prev : dp.keySet()) {
                int count = dp.get(prev);
                for (String next : compatible.get(prev)) {
                    newDp.put(next, (newDp.getOrDefault(next, 0) + count) % MOD);
                }
            }
            dp = newDp;
        }

        int res = 0;
        for (int val : dp.values()) {
            res = (res + val) % MOD;
        }
        return res;
    }

    private void generateStates(int[] state, int index, List<int[]> states) {
        if (index == state.length) {
            states.add(Arrays.copyOf(state, state.length));
            return;
        }
        for (int color = 0; color < 3; color++) {
            if (index == 0 || state[index - 1] != color) {
                state[index] = color;
                generateStates(state, index + 1, states);
            }
        }
    }

    private boolean isCompatible(int[] s1, int[] s2) {
        for (int i = 0; i < s1.length; i++) {
            if (s1[i] == s2[i]) return false;
        }
        return true;
    }
}
