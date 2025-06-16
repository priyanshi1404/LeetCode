class Solution {
    public int singleNonDuplicate(int[] nums) {
        int start=0;
        int end=nums.length-1;

        while(start < end){
            int mid= start + (end-start)/2;

        //checks if mid is on even index, if not then make position of mid even 
            if(mid%2==1){
                mid--;
            }
            //mid is at even index, pair found, now start the mid after the pair
            if(nums[mid] == nums[mid+1]){
                start=mid+2;
            } else{
                end=mid;
            }
        }
        return nums[start];
    }
}