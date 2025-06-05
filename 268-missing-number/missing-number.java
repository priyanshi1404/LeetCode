class Solution {
    //using SUM FORMULA
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int sum=n*(n+1)/2;
        for(int var:nums){
            sum=sum-var;
        }
        return sum;
    }
}