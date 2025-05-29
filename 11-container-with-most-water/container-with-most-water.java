class Solution {
    //Approach 2- TWO POINTER
    public int maxArea(int[] height){
        int left=0;
        int right=height.length-1;
        int max=0;
        while(left<right){
            int h=Math.min(height[left],height[right]);
            int w=right-left;
            int area=h*w;
            max=Math.max(area,max);
            if(height[left]<height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return max;
    }

    // //Approach 1- BRUTE FORCE when TC O(N^2)  it gives TLE(Time Limit Exceeded)
    // public int maxArea(int[] height) {
    //     int max=0;
    //     for(int i=0;i<height.length;i++){
    //         for(int j=i+1;j<height.length;j++){
    //             int h=Math.min(height[i],height[j]);
    //             int w=j-i;
    //             int area=h*w;
    //             max=Math.max(area,max);
    //         }
    //     }
    //     return max;
        
    // }
}