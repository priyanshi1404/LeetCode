class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;

        // Step 1: Apply the operation
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }

        // Step 2: Two-pointer shift
        int j = 0; // points to the next index to place non-zero
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }

        // Step 3: Fill the rest with 0s
        while (j < n) {
            nums[j++] = 0;
        }

        return nums;
    }
}
