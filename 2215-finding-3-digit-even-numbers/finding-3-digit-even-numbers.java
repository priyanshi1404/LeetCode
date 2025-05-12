

class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> result = new HashSet<>();
        
        int n = digits.length;
        
        for (int i = 0; i < n; i++) {
            if (digits[i] == 0) continue; // Skip leading 0
            for (int j = 0; j < n; j++) {
                if (j == i) continue;
                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) continue;
                    int num = digits[i] * 100 + digits[j] * 10 + digits[k];
                    if (num % 2 == 0) {
                        result.add(num);
                    }
                }
            }
        }
        
        int[] res = result.stream().sorted().mapToInt(x -> x).toArray();
        return res;
    }
}
