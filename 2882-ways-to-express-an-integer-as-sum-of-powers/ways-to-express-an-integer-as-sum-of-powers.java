class Solution {
    public int numberOfWays(int n, int x) {
        final int MOD = 1_000_000_007;
        int[] dp = new int[n + 1];
        dp[0] = 1;  // There's exactly one way to form sum 0

        // Generate all a^x values where a^x ≤ n
        for (int a = 1; ; a++) {
            long power = 1;
            for (int i = 0; i < x; i++) power *= a;
            if (power > n) break;
            int v = (int) power;

            // Traverse dp array backward to avoid reuse
            for (int sum = n; sum >= v; sum--) {
                dp[sum] = (dp[sum] + dp[sum - v]) % MOD;
            }
        }

        return dp[n];
    }
}
