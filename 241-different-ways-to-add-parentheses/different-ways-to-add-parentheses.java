class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*') {
                // Split and conquer
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));

                // Combine results
                for (int l : left) {
                    for (int r : right) {
                        if (ch == '+') result.add(l + r);
                        else if (ch == '-') result.add(l - r);
                        else if (ch == '*') result.add(l * r);
                    }
                }
            }
        }

        // If it's a number, not an expression
        if (result.isEmpty()) {
            result.add(Integer.parseInt(input));
        }

        return result;
    }
}
