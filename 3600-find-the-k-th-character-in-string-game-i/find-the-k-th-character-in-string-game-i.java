class Solution {
    public char kthCharacter(int k) {
        return findChar(k - 1, "a");
    }

    private char findChar(int index, String word) {
        if (index < word.length()) {
            return word.charAt(index); // ✅ Base case: the index is within the current word
        }

        // Build the next generation: original + incremented version
        StringBuilder next = new StringBuilder();
        for (char c : word.toCharArray()) {
            char nextChar = (char) ((c - 'a' + 1) % 26 + 'a');
            next.append(nextChar);
        }

        return findChar(index, word + next.toString()); // \U0001f501 Recursive call with updated word
    }
}
