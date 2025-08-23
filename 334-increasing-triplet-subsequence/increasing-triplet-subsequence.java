class Solution {
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;   // smallest so far
        int second = Integer.MAX_VALUE;  // second smallest so far
        
        for (int num : nums) {
            if (num <= first) {
                first = num;  // update first if smaller found
            } else if (num <= second) {
                second = num; // update second if num is between first and second
            } else {
                // found num > second => triplet exists
                return true;
            }
        }
        
        return false;
    }
}
