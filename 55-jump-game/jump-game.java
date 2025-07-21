class Solution {
    public boolean canJump(int[] nums) {
        int cache[]= new int[nums.length];
        return canReach(nums,0,cache);
    }
    boolean canReach(int[] nums,int index,int[] cache){
        //base case
        if(index>=nums.length-1){
            return true;
        }
        if(cache[index]!=0){
            return cache[index]==1;
        }
        int max=nums[index];
        for(int step=1;step<=max;step++){
            if(canReach(nums,index+step,cache)){
                cache[index]=1;
                return true;
            }

        }
        cache[index]=-1;
        return false;
    }
}