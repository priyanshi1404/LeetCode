class Solution {
    public int[] singleNumber(int[] nums) {
        int xor=0;
        for(int num:nums){
            xor^=num;
        }
        int diffBit=xor & (-xor); //finding the rightmost bit

        int a=0, b=0;
        for(int num: nums){
            if((num & diffBit) == 0){
                a^=num;
            }
            else{
                b^=num;
            }
        }
        return new int[]{a,b};
    }
}