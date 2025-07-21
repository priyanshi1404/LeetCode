class Solution {
    public int largestRectangleArea(int[] h) {
        //brute force approach
        if(h== null || h.length==0){
            return 0;
        }
        int n=h.length;
        int left[]= new int[n];
        left[0]=-1;

        int right[]=new int[n];
        right[n-1]=n;

        //fill left array
        for(int i=0;i<n;i++){
            int prev=i-1;
            while(prev>=0 && h[prev]>=h[i]){
                prev=left[prev];
            }
            left[i]=prev;
        }
        //Fill right array
        for(int i=n-2;i>=0;i--){
            int prev=i+1;
            while(prev<n &&  h[prev]>=h[i]){
                prev=right[prev];
            }
            right[i]=prev;
        }

        //calculatig the area
        int maxArea=0;
        for(int i=0;i<n;i++){
            maxArea=Math.max(maxArea,h[i] * (right[i] - left[i] - 1));
        }
        return maxArea;
    }
}