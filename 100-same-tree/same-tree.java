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
class Pair{
    TreeNode p;
    TreeNode q;
    Pair(TreeNode p,TreeNode q){
        this.p=p;
        this.q=q;
    }
}
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //Iterative Approach
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(p,q));
        while(!stack.isEmpty()){
            Pair pair=stack.pop();
            TreeNode node1=pair.p;
            TreeNode node2=pair.q;
            if(node1==null && node2==null){
                continue;
            }
            if(node1==null || node2==null){
                return false;
            }
            if(node1.val != node2.val){
                return false;
            }
            stack.push(new Pair(node1.left,node2.left));
            stack.push(new Pair(node1.right,node2.right));
        }
        return true;
        

        
        // if(p==null && q==null){
        //     return true;
        // }
        // if(p==null || q==null){
        //     return false;
        // }
        // if(p.val!=q.val){
        //     return false;
        // }
        // boolean  leftCompare= isSameTree(p.left,q.left);
        // boolean rightCompare= isSameTree(p.right,q.right);
        // return  leftCompare &&  rightCompare;
    }
}