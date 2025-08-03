class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n = fruits.length;
        int max = 0, sum = 0;
        int left = 0, right = 0;

        while (right < n) {
            int rightPos = fruits[right][0];
            sum += fruits[right][1];

            // Check if the current window is valid (can be reached in <= k steps)
            while (left <= right && !canReach(fruits[left][0], rightPos, startPos, k)) {
                sum -= fruits[left][1];
                left++;
            }

            max = Math.max(max, sum);
            right++;
        }

        return max;
    }

    // Can we go from startPos to fruits[left...right] using <= k steps?
    private boolean canReach(int left, int right, int start, int k) {
        int goLeftFirst = Math.abs(start - left) + Math.abs(right - left);
        int goRightFirst = Math.abs(start - right) + Math.abs(right - left);
        return Math.min(goLeftFirst, goRightFirst) <= k;
    }
}
