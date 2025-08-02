class Solution {
    public int myAtoi(String s) {
        int i = 0, sign = 1, n = s.length();
        long result = 0;

        // Step 1: Skip whitespaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // Step 2: Handle optional sign
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // Step 3: Read digits
        while (i < n && Character.isDigit(s.charAt(i))) {
            result = result * 10 + (s.charAt(i) - '0');

            // Step 4: Clamp if out of bounds
            if (sign * result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign * result < Integer.MIN_VALUE) return Integer.MIN_VALUE;

            i++;
        }

        return (int) (sign * result);
    }
}
