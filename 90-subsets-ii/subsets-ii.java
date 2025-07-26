class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> smallList= new ArrayList<>();
        List<List<Integer>> bigList= new ArrayList<>();
        Arrays.sort(nums);
        helper(nums,0,smallList,bigList);
        return bigList;
        
    }
    void helper(int[] nums,int index, List<Integer> smallList, List<List<Integer>> bigList){
        //not to add duplicate
        if(!bigList.contains(smallList)){
            bigList.add(new ArrayList<>(smallList));
        }
        for(int i=index; i <nums.length;i++){
            smallList.add(nums[i]);
            helper(nums,i+1,smallList,bigList);

            //backtracking
            smallList.remove(smallList.size()-1);

        }
    }
}