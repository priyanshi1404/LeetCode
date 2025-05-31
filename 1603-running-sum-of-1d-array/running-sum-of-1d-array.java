class Solution {
    public int[] runningSum(int[] nums) {
       
        for(int i=1;i<nums.length;i++){
           nums[i]=nums[i-1]+nums[i];
        }
        return nums;
        
    }

    //Approach 1-BRUTE FORCE TC(O(N))
    // public int[] runningSum(int[] nums) {
    //     int prefix[]=new int[nums.length];
    //     prefix[0]=nums[0];
    //     for(int i=1;i<nums.length;i++){
    //         prefix[i]=prefix[i-1]+nums[i];
    //     }
    //     return prefix;
        
    // }
}