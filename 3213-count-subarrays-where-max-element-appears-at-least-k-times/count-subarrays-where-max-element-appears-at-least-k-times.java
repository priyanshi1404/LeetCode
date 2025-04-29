class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        long count = 0;
        int maxFreq = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == max) {
                maxFreq++;
            }

            while (maxFreq >= k) {
                if (nums[left] == max) {
                    maxFreq--;
                }
                left++;
            }

            count += left;
        }

        return count;
    }
}
