class Solution {
    //Approach 02-TWO POINTER
    public int trap(int[] height){
        int left=0;
        int right=height.length-1;
        int leftMax=0;
        int rightMax=0;
        int water=0;
        while(left<right){
            if(height[left]<height[right]){
                if(height[left]>leftMax){
                    leftMax=height[left];
                }
                else{
                    water=water+leftMax-height[left];
                }
                left++;
            }
            else{
                if(height[right]>rightMax){
                    rightMax=height[right];
                }
                else{
                    water=water+rightMax-height[right];
                }
                right--;
            }
        }
        return water;
    }

    //Approach 1-BRUTE FORCE
    // public int trap(int[] height) {
    //     int totalWater=0;
    //     // i means the current pillar
    //     for(int i=0;i<height.length;i++){
    //         //check from current pillar which is max from the left
    //         int leftMax=0;
    //         for(int j=i;j>=0;j--){
    //             leftMax=Math.max(height[j],leftMax);
    //         }
    //          //check from current pillar which is max from the right
    //         int rightMax=0;
    //         for(int j=i;j<height.length;j++){
    //             rightMax=Math.max(height[j],rightMax);
    //         }
    //         int h=Math.min(leftMax,rightMax);
    //         int water=h-height[i];
    //         totalWater=totalWater+water;
    //     }
    //      return totalWater;
    // }
   

    
}