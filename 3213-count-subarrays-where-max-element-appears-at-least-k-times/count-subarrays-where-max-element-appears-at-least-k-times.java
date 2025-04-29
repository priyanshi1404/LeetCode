class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;

        // Step 1: Find the maximum element in the array
        for (int num : nums) {
            max = Math.max(max, num);
        }

        long ans = 0;
        int left = 0;
        int maxCount = 0;

        // Step 2: Sliding window approach
        for (int right = 0; right < n; right++) {
            if (nums[right] == max) {
                maxCount++;
            }

            // When we have enough max elements in the current window
            while (maxCount >= k) {
                if (nums[left] == max) {
                    maxCount--;
                }
                left++;
            }

            // Add the number of valid subarrays ending at `right`
            ans += left;
        }

        return ans;
    }
}
