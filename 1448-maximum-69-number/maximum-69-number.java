class Solution {
    public int maximum69Number (int num) {
        char[] digits = String.valueOf(num).toCharArray();

        // Change the first '6' we see into '9'
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == '6') {
                digits[i] = '9';
                break; // only one change allowed
            }
        }

        return Integer.parseInt(new String(digits));
    }
}
