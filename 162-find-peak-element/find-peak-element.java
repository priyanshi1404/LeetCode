class Solution {
    //approach 02- using BS
    public int findPeakElement(int[] nums){
        int start=0;
        int end=nums.length-1;

        while(start < end){
            int mid= start + (end-start)/2;
            if(nums[mid] < nums[mid+1]){
                start= mid+1;
            }
            else{
                end = mid;
            }
        }
        return start;


    }

    //approach 01-brute force
    // public int findPeakElement(int[] nums) {
    //     int n=nums.length;

    //     for(int i=0; i<n; i++){
    //         if((i==0 || nums[i]>nums[i-1]) && (i==(n-1)  || nums[i]>nums[i+1]))
    //         return i;
    //     }
    //     return -1;
        
    // }
}














