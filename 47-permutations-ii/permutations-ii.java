class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);  // Important to handle duplicates

        boolean[] used = new boolean[nums.length];
        backtrack(nums, new ArrayList<>(), used, result);

        return result;
    }

    private void backtrack(int[] nums, List<Integer> path, boolean[] used, List<List<Integer>> result) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // Skip used elements
            if (used[i]) continue;

            // Skip duplicates: if current = previous and previous not used in current path
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

            path.add(nums[i]);
            used[i] = true;

            backtrack(nums, path, used, result);

            // Backtrack
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}
