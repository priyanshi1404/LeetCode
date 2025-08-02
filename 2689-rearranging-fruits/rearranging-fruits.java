import java.util.*;

class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer, Integer> freq = new HashMap<>();
        int minFruit = Integer.MAX_VALUE;

        for (int fruit : basket1) {
            freq.put(fruit, freq.getOrDefault(fruit, 0) + 1);
            minFruit = Math.min(minFruit, fruit);
        }

        for (int fruit : basket2) {
            freq.put(fruit, freq.getOrDefault(fruit, 0) - 1);
            minFruit = Math.min(minFruit, fruit);
        }

        List<Integer> extra1 = new ArrayList<>();
        List<Integer> extra2 = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int fruit = entry.getKey();
            int count = entry.getValue();

            if (count % 2 != 0) return -1; // not possible

            int times = Math.abs(count) / 2;
            if (count > 0) {
                for (int i = 0; i < times; i++) extra1.add(fruit);
            } else if (count < 0) {
                for (int i = 0; i < times; i++) extra2.add(fruit);
            }
        }

        if (extra1.size() != extra2.size()) return -1;

        Collections.sort(extra1);
        Collections.sort(extra2, Collections.reverseOrder());

        long cost = 0;
        for (int i = 0; i < extra1.size(); i++) {
            int a = extra1.get(i);
            int b = extra2.get(i);
            cost += Math.min(Math.min(a, b), 2 * minFruit);
        }

        return cost;
    }
}
