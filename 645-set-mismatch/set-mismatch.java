class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        boolean[] seen = new boolean[n + 1];
        int duplicate = -1, sum = 0;
        
        for (int num : nums) {
            if (seen[num]) {
                duplicate = num;
            }
            seen[num] = true;
            sum += num;
        }
        
        int expected = n * (n + 1) / 2;
        int missing = expected - (sum - duplicate);
        
        return new int[]{duplicate, missing};
    }
}
