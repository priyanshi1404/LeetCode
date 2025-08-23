import java.util.Arrays;

class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);  // sort ascending
        for (int i = nums.length - 1; i >= 2; i--) {
            int a = nums[i], b = nums[i - 1], c = nums[i - 2];
            if (b + c > a) {   // triangle condition
                return a + b + c;
            }
        }
        return 0;
    }
}
