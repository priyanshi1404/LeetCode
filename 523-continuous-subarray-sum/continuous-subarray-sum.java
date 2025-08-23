import java.util.*;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // remainder 0 at index -1 (to handle case from start)

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int rem = k == 0 ? sum : sum % k;

            if (map.containsKey(rem)) {
                if (i - map.get(rem) > 1) {
                    return true; // valid subarray found
                }
            } else {
                map.put(rem, i); // store earliest index
            }
        }
        return false;
    }
}
