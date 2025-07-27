class Solution {
    int minUnfair = Integer.MAX_VALUE;

    public int distributeCookies(int[] cookies, int k) {
        int[] children = new int[k];
        backtrack(cookies, 0, children, k);
        return minUnfair;
    }

    private void backtrack(int[] cookies, int idx, int[] children, int k) {
        if (idx == cookies.length) {
            int max = 0;
            for (int val : children) {
                max = Math.max(max, val);
            }
            minUnfair = Math.min(minUnfair, max);
            return;
        }

        for (int i = 0; i < k; i++) {
            children[i] += cookies[idx];
            
            // Prune if current max >= already found min unfair
            if (children[i] < minUnfair) {
                backtrack(cookies, idx + 1, children, k);
            }

            children[i] -= cookies[idx];

            // Symmetry breaking: don't assign first cookie to multiple empty children
            if (children[i] == 0) break;
        }
    }
}
