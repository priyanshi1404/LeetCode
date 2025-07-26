class Solution {
    public int combinationSum4(int[] nums, int target) {
        return backtrack(nums, target, new HashMap<>());
    }

    private int backtrack(int[] nums, int target, Map<Integer, Integer> memo) {
        if (target == 0) return 1;      // valid path
        if (target < 0) return 0;       // invalid path
        if (memo.containsKey(target)) return memo.get(target);

        int count = 0;
        for (int num : nums) {
            count += backtrack(nums, target - num, memo);
        }

        memo.put(target, count); // store result for this target
        return count;
    }
}
