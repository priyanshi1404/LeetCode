class Solution {
    public boolean isPalindrome(int x) {
        // Negative numbers are not palindromes
        // Also, numbers ending in 0 that aren't 0 are not palindromes (e.g., 10, 100)
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversed = 0;
        while (x > reversed) {
            reversed = reversed * 10 + x % 10;
            x = x / 10;
        }

        // For even length numbers: x == reversed
        // For odd length numbers: x == reversed / 10
        return x == reversed || x == reversed / 10;
    }
}
