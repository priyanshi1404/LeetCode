class Solution {
    public long countSubarrays(int[] nums, long k) {
        long ans = 0;
        long sum = 0;
        int left = 0;
        int n = nums.length;

        for (int right = 0; right < n; right++) {
            sum += nums[right];

            // Instead of recalculating right-left+1 every time, use a variable
            while (sum * (right - left + 1) >= k) {
                sum -= nums[left++];
            }
            
            ans += (right - left + 1);
        }

        return ans;
    }
}
