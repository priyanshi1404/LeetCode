class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int index, int target, List<Integer> path, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(path)); // found a valid combination
            return;
        }
        if (target < 0) return; // too much, stop

        for (int i = index; i < candidates.length; i++) {
            path.add(candidates[i]); // choose
            backtrack(candidates, i, target - candidates[i], path, result); // stay on i because we can reuse
            path.remove(path.size() - 1); // un-choose
        }
    }
}
