class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean [] isVisited = new boolean[nums.length]; //all are filled with false
        List<Integer> smallList= new ArrayList<>();
        List<List<Integer>> bigList= new ArrayList<>();
        helper(nums,smallList,bigList,isVisited);
        return bigList;
    }
    //helper function
    void helper(int nums[], List<Integer> smallList, List<List<Integer>> bigList, boolean [] isVisited){
        //base case
        if(nums.length == smallList.size() && !bigList.contains(smallList)){
            bigList.add(new ArrayList<>(smallList));
            return;  //Stack fall starts from here
        }
        //start all the branch
        for(int i=0; i<nums.length; i++){
            if(!isVisited[i]){
                smallList.add(nums[i]);
                isVisited[i] = true;  //it is marked now

                // now a recursive call
                helper(nums,smallList,bigList,isVisited);

                //Bactracking
                smallList.remove(smallList.size()-1);  //remove the last element
                isVisited[i]= false;
            }
        }
    }
}