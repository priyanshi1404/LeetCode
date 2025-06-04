class Solution {
    //Approach 01-BRUTE FORCE 
    public int pivotIndex(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int leftSum=0;
            for(int j=0;j<i;j++){
                leftSum=leftSum+nums[j];
            }
            int rightSum=0;
            for(int j=i+1;j<nums.length;j++){
                rightSum=rightSum+nums[j];
            }
            if(leftSum==rightSum){
                return i;
            }
        }
        return -1;
        
    }
}