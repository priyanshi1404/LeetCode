class Solution {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        int left = 0;
        long sum = 0;
        long count = 0;

        for (int right = 0; right < n; right++) {
            sum += nums[right];

            // Check if score >= k
            while (left <= right && sum * (right - left + 1) >= k) {
                sum -= nums[left];
                left++;
            }

            count += (right - left + 1);
        }

        return count;
    }
}
