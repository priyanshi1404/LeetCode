class Solution {
    //Approach 3-Boyer-Moore voting Algo
    public int majorityElement(int[] nums) {
        int count=0;
        int majElement=0;
        for(int num:nums){
            if(count==0){
                majElement=num;
            }
            if(num==majElement){
                count++;
            }
            else{
                count--;
            }
        }
        return majElement;
    }
    //Approach 2-Hashing
    // public int majorityElement(int[] nums) {
    //     int n=nums.length;
    //     HashMap<Integer,Integer> map=new HashMap<>();
    //     for(int i=0;i<nums.length;i++){
    //         map.put(nums[i],map.getOrDefault(nums[i],0)+1);
    //         if(map.get(nums[i])>n/2){
    //             return nums[i];
    //         }
    //     }
    //     return -1;
    // }
    
    //Approach 1-BRUTE FORCE
    // public int majorityElement(int[] nums) {
    //     int n=nums.length;
    //     for(int i=0;i<nums.length;i++){
    //         int count=0;
    //         for(int j=0;j<nums.length;j++){
    //             if(nums[i] == nums[j]){
    //                 count++;
    //             }
    //         }
    //         if(count>n/2){
    //             return nums[i];
    //         }
    //     }
    //     return -1;
    // }
}