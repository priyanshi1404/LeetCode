class Solution {
    private static final String[] KEYPAD = {
        "",     "",     "abc", "def", "ghi",
        "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) return result;

        backtrack(digits, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(String digits, int index, StringBuilder path, List<String> result) {
        if (index == digits.length()) {
            result.add(path.toString());
            return;
        }

        String letters = KEYPAD[digits.charAt(index) - '0'];
        for (char ch : letters.toCharArray()) {
            path.append(ch);
            backtrack(digits, index + 1, path, result);
            path.deleteCharAt(path.length() - 1); // backtrack
        }
    }
}
