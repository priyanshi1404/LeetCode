import java.util.*;

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> orderMap = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            orderMap.put(arr2[i], i);
        }

        // Custom comparator for sorting arr1
        Integer[] temp = Arrays.stream(arr1).boxed().toArray(Integer[]::new);
        Arrays.sort(temp, (a, b) -> {
            if (orderMap.containsKey(a) && orderMap.containsKey(b)) {
                return orderMap.get(a) - orderMap.get(b);  // sort by arr2 order
            } else if (orderMap.containsKey(a)) {
                return -1;  // a comes first
            } else if (orderMap.containsKey(b)) {
                return 1;   // b comes first
            } else {
                return a - b; // normal ascending
            }
        });

        return Arrays.stream(temp).mapToInt(i -> i).toArray();
    }
}
