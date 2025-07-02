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
    int preOrderIndex=0;
    Map<Integer,Integer> map= new HashMap<>(); //inorder map
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper(preorder,0,preorder.length-1);
    }
    TreeNode helper(int[] preorder, int start,int end){
        if(start>end){
            return null;
        }
        int nodeValue=preorder[preOrderIndex];
        preOrderIndex++;
        TreeNode node=new TreeNode(nodeValue);
        if(start == end){
            return node;
        }
        int index=map.get(nodeValue);
        node.left=helper(preorder,start,index-1);
        node.right=helper(preorder,index+1,end);
        return node;
    }
}