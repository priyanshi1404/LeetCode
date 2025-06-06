class Solution {
    //approach 02
    public void rotate(int[] nums, int k){
        int n=nums.length;
        k=k%n;
        int temp[]=new int[n];
        for(int i=0;i<n;i++){
            temp[(i + k) % n] = nums[i]; 
        }
        for(int i=0;i<n;i++){
            nums[i]=temp[i];
        }
    }
    // approach 01- BRUTE FORCE  TC(O(N^k)) TLE
    public void rotateOld(int[] nums, int k) {
        int n=nums.length;
        k=k%n;  //it keeps the array in bounds

        for(int i=0;i<k;i++){
            int last=nums[n-1];  //saving because after one rotation the last element will be deleted hence we need to save it
            for(int j=n-1;j>0;j--){
                nums[j]=nums[j-1];
            }
            nums[0]=last;
        }
    }
}