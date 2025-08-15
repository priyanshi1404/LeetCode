class Solution {
    static final int MOD = 1_000_000_007;

    public int[] productQueries(int n, int[][] queries) {
        // Step 1: Extract powers of 2 from n
        List<Integer> powers = new ArrayList<>();
        for (int bit = 0; bit < 32; bit++) {
            if ((n & (1 << bit)) != 0) {
                powers.add(1 << bit);
            }
        }

        // Step 2: Build prefix product array
        int m = powers.size();
        long[] prefix = new long[m + 1];
        prefix[0] = 1;
        for (int i = 0; i < m; i++) {
            prefix[i + 1] = (prefix[i] * powers.get(i)) % MOD;
        }

        // Step 3: Answer queries using modular division
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0], r = queries[i][1];
            long prod = prefix[r + 1] * modInverse(prefix[l], MOD) % MOD;
            result[i] = (int) prod;
        }

        return result;
    }

    // Modular inverse using fast exponentiation (Fermat's Little Theorem)
    private long modInverse(long a, int mod) {
        return pow(a, mod - 2, mod);
    }

    private long pow(long a, long b, int mod) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) res = (res * a) % mod;
            a = (a * a) % mod;
            b >>= 1;
        }
        return res;
    }
}
