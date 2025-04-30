class Solution {
    public int totalNumbers(int[] digits) {
        Set<Integer> set = new HashSet<>();

        int n = digits.length;

        // Try all combinations of 3 different digits
        for (int i = 0; i < n; i++) {
            if (digits[i] == 0) continue; // First digit can't be 0

            for (int j = 0; j < n; j++) {
                if (j == i) continue;

                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) continue;

                    int num = digits[i] * 100 + digits[j] * 10 + digits[k];

                    if (num % 2 == 0) { // Number must be even
                        set.add(num);  // Add to set for uniqueness
                    }
                }
            }
        }

        return set.size();
    }
}
