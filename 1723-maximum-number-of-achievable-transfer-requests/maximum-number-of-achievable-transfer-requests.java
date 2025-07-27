class Solution {
    int maxRequests = 0;

    public int maximumRequests(int n, int[][] requests) {
        int[] count = new int[n];
        backtrack(requests, 0, count, 0);
        return maxRequests;
    }

    private void backtrack(int[][] req, int idx, int[] count, int fulfilled) {
        if (idx == req.length) {
            for (int c : count) {
                if (c != 0) return; // imbalance
            }
            maxRequests = Math.max(maxRequests, fulfilled);
            return;
        }

        // ❌ Option 1: Skip current request
        backtrack(req, idx + 1, count, fulfilled);

        // ✅ Option 2: Take current request
        int from = req[idx][0];
        int to = req[idx][1];

        count[from]--;
        count[to]++;

        backtrack(req, idx + 1, count, fulfilled + 1);

        // Undo the change (backtrack)
        count[from]++;
        count[to]--;
    }
}
