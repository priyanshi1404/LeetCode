class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] trustScore = new int[n + 1]; // index 0 unused

        for (int[] t : trust) {
            int a = t[0], b = t[1];
            trustScore[a]--; // a trusts someone → not judge
            trustScore[b]++; // b is trusted
        }

        for (int i = 1; i <= n; i++) {
            if (trustScore[i] == n - 1) return i;
        }

        return -1;
    }
}
