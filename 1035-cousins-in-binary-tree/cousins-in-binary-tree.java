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
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean foundX = false, foundY = false;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.val == x) foundX = true;
                if (node.val == y) foundY = true;

                // Check if x and y are siblings (same parent)
                if (node.left != null && node.right != null) {
                    int l = node.left.val;
                    int r = node.right.val;
                    if ((l == x && r == y) || (l == y && r == x)) {
                        return false; // same parent, not cousins
                    }
                }

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            // Found both on same level, different parents
            if (foundX && foundY) return true;

            // Found only one? Then they're not at the same level
            if (foundX || foundY) return false;
        }

        return false;
    }
}
