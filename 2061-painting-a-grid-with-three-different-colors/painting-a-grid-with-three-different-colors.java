class Solution {
    static final int MOD = 1_000_000_007;

    public int colorTheGrid(int m, int n) {
        List<Integer> states = new ArrayList<>();
        Map<Integer, Integer> stateToIndex = new HashMap<>();

        generateStates(0, -1, m, 0, states);

        int size = states.size();
        for (int i = 0; i < size; i++) {
            stateToIndex.put(states.get(i), i);
        }

        // Build transition matrix
        long[][] T = new long[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (isCompatible(states.get(i), states.get(j), m)) {
                    T[i][j] = 1;
                }
            }
        }

        // Matrix exponentiation: T^(n-1)
        long[][] T_pow = matrixPower(T, n - 1);

        // Initial vector (all ones)
        long[] dp = new long[size];
        Arrays.fill(dp, 1);

        // Multiply T^(n-1) * dp
        long result = 0;
        for (int i = 0; i < size; i++) {
            long sum = 0;
            for (int j = 0; j < size; j++) {
                sum = (sum + T_pow[i][j] * dp[j]) % MOD;
            }
            result = (result + sum) % MOD;
        }

        return (int) result;
    }

    private void generateStates(int pos, int prevColor, int m, int state, List<Integer> result) {
        if (pos == m) {
            result.add(state);
            return;
        }

        for (int c = 0; c < 3; c++) {
            if (c != prevColor) {
                generateStates(pos + 1, c, m, state * 3 + c, result);
            }
        }
    }

    private boolean isCompatible(int a, int b, int m) {
        for (int i = 0; i < m; i++) {
            if (a % 3 == b % 3) return false;
            a /= 3;
            b /= 3;
        }
        return true;
    }

    private long[][] matrixMultiply(long[][] A, long[][] B) {
        int n = A.length;
        long[][] C = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (A[i][k] == 0) continue;
                for (int j = 0; j < n; j++) {
                    C[i][j] = (C[i][j] + A[i][k] * B[k][j]) % MOD;
                }
            }
        }
        return C;
    }

    private long[][] matrixPower(long[][] A, int power) {
        int n = A.length;
        long[][] res = new long[n][n];
        for (int i = 0; i < n; i++) res[i][i] = 1;

        while (power > 0) {
            if ((power & 1) == 1) {
                res = matrixMultiply(res, A);
            }
            A = matrixMultiply(A, A);
            power >>= 1;
        }
        return res;
    }
}
