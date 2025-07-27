class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtrack(nums, 0, new ArrayList<>());
        return result;
    }

    private void backtrack(int[] nums, int start, List<Integer> path) {
        if (path.size() >= 2) {
            result.add(new ArrayList<>(path)); // Add copy to result
        }

        Set<Integer> used = new HashSet<>(); // For this recursion level

        for (int i = start; i < nums.length; i++) {
            // Skip duplicates in same recursion layer
            if (used.contains(nums[i])) continue;

            // Ensure non-decreasing order
            if (path.isEmpty() || nums[i] >= path.get(path.size() - 1)) {
                used.add(nums[i]);
                path.add(nums[i]);
                backtrack(nums, i + 1, path);
                path.remove(path.size() - 1); // backtrack
            }
        }
    }
}
