class Solution {
    //approach 01-brute force
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i=nums1.length;
        int j=nums2.length;
        int[] nums3=new int[i+j]; //creates an array whose size is equal to the two arrays given.
        int p=0,q=0,r=0;

       //merge the two arrays
        while(p<i && q<j){
            if(nums1[p]>nums2[q]){
                nums3[r++]=nums2[q++];
            }
            else{
                nums3[r++]=nums1[p++];
            }
        }

        //copy the remaining elements
        while(p< i){
            nums3[r++]=nums1[p++];
        }
        while(q<j){
            nums3[r++]=nums2[q++];
        }

        //finding the median
        int totalLength=i+j;
        if(totalLength%2==1){
            return nums3[totalLength/2];
        }
        else{
            return (nums3[totalLength/2]+nums3[totalLength/2-1])/2.0;
        }
        
    }
}