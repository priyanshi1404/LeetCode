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
    private int postIndex;
    private Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1;

        // Build hashmap to store value -> index relations
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return build(inorder, postorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] inorder, int[] postorder, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }

        // Pick current root from postorder
        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);

        // Root splits inorder array into left and right
        int inorderIndex = inorderIndexMap.get(rootVal);

        // Important: Build right subtree first (because of postorder)
        root.right = build(inorder, postorder, inorderIndex + 1, inEnd);
        root.left = build(inorder, postorder, inStart, inorderIndex - 1);

        return root;
    }
}
