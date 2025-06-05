class Solution {
    //approach 02- KADANE'S 
    public int maxSubArray(int[] nums){
        int maxSum=nums[0];
        int sum=nums[0];
        for(int i=1;i<nums.length;i++){
            sum+=nums[i];
            sum=Math.max(sum,nums[i]);
            maxSum=Math.max(sum,maxSum);
        }
        return maxSum;
    }

    //approach 01- BRUTE FORCE
    // public int maxSubArray(int[] nums) {
    //     int maxSum=0;
    //     for(int i=0;i<nums.length;i++){
    //         int currentSum=0;
    //         for(int j=0;j<nums.length;j++){

    //         }
    //     }
        
    // }
}