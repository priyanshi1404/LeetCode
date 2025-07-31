import java.util.*;

class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        Map<Integer, Integer> prefixSumFreq = new HashMap<>();
        prefixSumFreq.put(0, 1);  // to count subarrays that directly sum to k

        for (int num : nums) {
            sum += num;

            if (prefixSumFreq.containsKey(sum - k)) {
                count += prefixSumFreq.get(sum - k);
            }

            prefixSumFreq.put(sum, prefixSumFreq.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
