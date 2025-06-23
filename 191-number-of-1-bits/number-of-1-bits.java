class Solution {
    public int hammingWeight(int n) {
        //approach 01-using predefined function
        // return Integer.bitCount(n);  

         //Approach 02-
        int count=0;
         while(n>0){
        n=n&(n-1);
        count++;
        }
        return count;
    }
}