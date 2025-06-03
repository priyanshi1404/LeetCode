class Solution {
    public int[] applyOperations(int[] nums) {
        //applying the operations
        int n=nums.length;
        for(int i=0;i<n-1;i++){
            if(nums[i]==nums[i+1]){
                nums[i]=nums[i]*2;
                nums[i+1]=0;
            }
        }
            //shifting the non-zeroes elements to the front of array
            int index=0;

            for(int num:nums){
                if(num!=0){
                    nums[index]=num;
                    index++;
                }
            }
                while(index<n){
                    nums[index]=0;
                    index++;
                }
         return nums;
    } 
}