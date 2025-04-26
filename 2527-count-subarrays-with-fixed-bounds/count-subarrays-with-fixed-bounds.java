class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;
        int lastMin = -1, lastMax = -1, lastInvalid = -1;
        long count = 0;
        
        for (int i = 0; i < n; i++) {
            if (nums[i] < minK || nums[i] > maxK) {
                lastInvalid = i;
            }
            if (nums[i] == minK) {
                lastMin = i;
            }
            if (nums[i] == maxK) {
                lastMax = i;
            }
            int validStart = Math.min(lastMin, lastMax);
            if (validStart > lastInvalid) {
                count += validStart - lastInvalid;
            }
        }
        
        return count;
    }
}
