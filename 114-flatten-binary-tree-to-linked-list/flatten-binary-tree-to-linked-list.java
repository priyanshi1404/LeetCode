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
    private TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null) return;

        flatten(root.right);  // go right first
        flatten(root.left);   // then left

        root.right = prev;    // point to previous node
        root.left = null;     // remove left link
        prev = root;          // update previous
    }
}
