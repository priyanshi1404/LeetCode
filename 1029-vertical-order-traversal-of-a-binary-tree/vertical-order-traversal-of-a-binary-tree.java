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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> bigList= new ArrayList<>();
        TreeMap<Integer,List<Pair<Integer,Integer>>> map= new TreeMap<>();
        helper(map,root,0,0);

        //final thing is to convert into List<List<Integer>> and sorted by distance
        for(Integer key: map.keySet()){
            List<Pair<Integer,Integer>> list= map.get(key);
            list.sort((a,b)->a.getKey().compareTo(b.getKey())==0?a.getValue().compareTo(b.getValue()):a.getKey().compareTo(b.getKey()));
                List<Integer> smallList=new ArrayList<>();
                for(Pair<Integer,Integer> pair:list){
                    smallList.add(pair.getValue());
                }
                bigList.add(smallList);
        }
        return bigList;
        
    }
    void helper(TreeMap<Integer,List<Pair<Integer,Integer>>> map,TreeNode root, int level,int distance){
        if(root == null){
            return;
        }
        if(map.get(distance) == null){
            map.put(distance, new ArrayList<>());
        }
        map.get(distance).add(new Pair<>(level,root.val));
        helper(map,root.left,level+1,distance-1);
        helper(map,root.right,level+1,distance+1);
    }
}