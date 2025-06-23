class Solution {
    public int singleNumber(int[] nums) {
        int result = 0; //this contains the number which is coming once
        //bit by bit traverse
        for(int i=0;i<32;i++){
            int count =0; //count the bit
            for(int num: nums){
                //check the 'on'ith bit
                if((num>>i & 1) == 1){
                    count++;
                }
            }
            if(count%3!= 0){
                result=result | (1<<i); //set the bit
            }
        }
        return result;
    }
}