class Solution {
    static final int MOD = 1_000_000_007;

    public int colorTheGrid(int m, int n) {
        List<Integer> validStates = new ArrayList<>();
        Map<Integer, List<Integer>> compatible = new HashMap<>();

        generateValidStates(0, -1, m, 0, validStates);

        for (int a : validStates) {
            for (int b : validStates) {
                if (isCompatible(a, b, m)) {
                    compatible.computeIfAbsent(a, x -> new ArrayList<>()).add(b);
                }
            }
        }

        Map<Integer, Integer> dp = new HashMap<>();
        for (int state : validStates) {
            dp.put(state, 1);
        }

        for (int i = 1; i < n; i++) {
            Map<Integer, Integer> newDp = new HashMap<>();
            for (int prev : dp.keySet()) {
                int count = dp.get(prev);
                for (int next : compatible.get(prev)) {
                    newDp.put(next, (newDp.getOrDefault(next, 0) + count) % MOD);
                }
            }
            dp = newDp;
        }

        int result = 0;
        for (int val : dp.values()) {
            result = (result + val) % MOD;
        }

        return result;
    }

    private void generateValidStates(int pos, int prevColor, int m, int currState, List<Integer> states) {
        if (pos == m) {
            states.add(currState);
            return;
        }

        for (int color = 0; color < 3; color++) {
            if (color != prevColor) {
                generateValidStates(pos + 1, color, m, currState * 3 + color, states);
            }
        }
    }

    private boolean isCompatible(int a, int b, int m) {
        for (int i = 0; i < m; i++) {
            int ca = a % 3;
            int cb = b % 3;
            if (ca == cb) return false;
            a /= 3;
            b /= 3;
        }
        return true;
    }
}
