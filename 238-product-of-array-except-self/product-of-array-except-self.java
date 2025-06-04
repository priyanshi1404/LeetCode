class Solution {
    //approach 02-PRE-COMPUTATION
    public int[] productExceptSelf(int[] nums){
        int prefix[]=new int[nums.length];
        int suffix[]=new int[nums.length];
        int result[]=new int[nums.length];
        prefix[0]=1;
        for(int i=1;i<nums.length;i++){
            prefix[i]=prefix[i-1]*nums[i-1];
        }
         suffix[nums.length-1]=1;
        for(int i=nums.length-2;i>=0;i--){
            suffix[i]=suffix[i+1]*nums[i+1];
    }
        for(int i=0;i<nums.length;i++){
            result[i]=prefix[i]*suffix[i];
        }
        return result;
    
    //Approach 01-BRUTE FORCE
    // public int[] productExceptSelfOld(int[] nums) {
    //     int result[]= new int[nums.length];
    //     for(int i=0;i<nums.length;i++){
    //         int product=1;
    //         for(int j=0;j<nums.length;j++){
    //             if(i!=j){
    //                 product=product*nums[j];
    //             }
    //         }
    //         result[i]=product;
    //     }
    //     return result;
    // }
     
}
}
