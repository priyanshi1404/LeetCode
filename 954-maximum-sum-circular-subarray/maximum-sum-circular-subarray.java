class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        int maxSum = nums[0];
        int curMax = 0;
        int minSum = nums[0];
        int curMin = 0;

        for (int num : nums) {
            curMax = Math.max(num, curMax + num); // Kadane's for max
            maxSum = Math.max(maxSum, curMax);

            curMin = Math.min(num, curMin + num); // Kadane's for min
            minSum = Math.min(minSum, curMin);

            totalSum += num;
        }

        if (maxSum < 0) {
            return maxSum; // all negatives
        }

        return Math.max(maxSum, totalSum - minSum); // either normal max or circular max
    }
}
