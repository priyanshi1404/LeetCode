/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        dfs(root, targetSum, path, result);

        return result;
    }

    private void dfs(TreeNode node, int target, List<Integer> path, List<List<Integer>> result) {
        if (node == null) return;

        path.add(node.val); // choose current node

        // check if it's a leaf and sum matches
        if (node.left == null && node.right == null && target == node.val) {
            result.add(new ArrayList<>(path)); // copy the path
        } else {
            dfs(node.left, target - node.val, path, result);  // left subtree
            dfs(node.right, target - node.val, path, result); // right subtree
        }

        path.remove(path.size() - 1); // backtrack
    }
}
