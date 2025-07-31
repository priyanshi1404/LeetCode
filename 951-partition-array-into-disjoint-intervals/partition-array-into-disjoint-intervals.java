class Solution {
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int maxLeft = nums[0];
        int max = nums[0];
        int partitionIdx = 0;

        for (int i = 1; i < n; i++) {
            max = Math.max(max, nums[i]);

            if (nums[i] < maxLeft) {
                // Not safe to move to right → expand left
                maxLeft = max;
                partitionIdx = i;
            }
        }

        return partitionIdx + 1;
    }
}
