class Solution {
    //Approach 02- PRE-COMPUTATION
    public int pivotIndex(int[] nums){
        //pre-compute sum
        int sum=0;
        for(int i:nums){
            sum=sum+i;
        }
        int left=0;
        //i have total sum
        for(int i=0;i<nums.length;i++){
            int right=sum-left-nums[i];
            if(left==right){
                return i;
            }
            left=left+nums[i];
        }
        return -1;
    }

    //Approach 01-BRUTE FORCE TC-O(n^2)
    public int pivotIndexOld(int[] nums) {
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