class Solution {
    //Approach 02-using Two pointers

     public int[] twoSum(int[] nums, int target){
        //duplicate array to maintain original index

        int aux[]=Arrays.copyOf(nums,nums.length);  //array elements are copied one by one in aux[]
        //int [] aux=nums;  it copies address
        Arrays.sort(nums);
        int left=0;
        int right=nums.length-1;
        int firstValue=-1;
        int secondValue=-1;
        while(left<=right){
            int sum=nums[left] + nums[right];
            if(sum==target){
                firstValue=nums[left];
                secondValue=nums[right];
                break;
            }
            else if(sum>target){
                right--;
            }
            else{
                left++;
            }
        }
        int firstIndex=-1;
        int secondIndex=-1;
        for(int i=0;i<aux.length;i++){
            if(firstIndex==-1 && aux[i]==firstValue){
                firstIndex=i;
            }
            else if(secondIndex==-1 && aux[i]==secondValue){
                secondIndex=i;
            }
        }
        return new int[]{firstIndex,secondIndex};
     }
        //approach 01-using hash map

    // public int[] twoSum(int[] nums, int target) {
    //     int pair[]=new int[2]; //by default{0,0}
    //     HashMap <Integer,Integer> map=new HashMap<>();
    //     for(int i=0;i<nums.length;i++){
    //         int result=target-nums[i];
    //         if(map.get(result)!=null){  //second pair exists it searches if the element is available in hash or not
    //             pair[0]=map.get(result); //first pair index
    //             pair[1]=i;  //second pair index
    //             return pair;
    //         }
    //         map.put(nums[i],i);  //store the first pair
    //     }
    //     return pair;
    // }
}