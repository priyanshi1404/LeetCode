class Solution {
    public void moveZeroes(int[] nums) {
        int insertPos = 0;

        // First pass: move non-zeros forward
        for (int num : nums) {
            if (num != 0) {
                nums[insertPos] = num;
                insertPos++;
            }
        }

        // Second pass: fill remaining with zeros
        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }
}
