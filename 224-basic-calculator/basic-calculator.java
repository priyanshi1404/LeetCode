

class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;      // running result
        int number = 0;      // current number
        int sign = 1;        // current sign, 1 for +, -1 for -

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                number = number * 10 + (ch - '0');  // build the number
            } else if (ch == '+') {
                result += sign * number;  // add the previous number
                number = 0;
                sign = 1;
            } else if (ch == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } else if (ch == '(') {
                // Push current result and sign into stack for later
                stack.push(result);
                stack.push(sign);
                // Reset for new context
                result = 0;
                sign = 1;
            } else if (ch == ')') {
                result += sign * number;  // complete current expression
                number = 0;
                result *= stack.pop();    // apply sign before parentheses
                result += stack.pop();    // add result before parentheses
            }
        }

        // Add any last number
        if (number != 0) {
            result += sign * number;
        }

        return result;
    }
}
