class Solution {
    public String longestSubsequenceRepeatedK(String s, int k) {
        // Count frequency of characters in s
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Filter characters that appear at least k times
        List<Character> candidates = new ArrayList<>();
        for (char c = 'z'; c >= 'a'; c--) {
            if (freq[c - 'a'] >= k) {
                candidates.add(c);
            }
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer("");

        String best = "";

        while (!queue.isEmpty()) {
            String curr = queue.poll();

            for (char c : candidates) {
                String next = curr + c;

                if (isRepeatedSubsequence(s, next, k)) {
                    if (next.length() > best.length() || (next.length() == best.length() && next.compareTo(best) > 0)) {
                        best = next;
                    }
                    queue.offer(next); // only continue if it's valid
                }
            }
        }

        return best;
    }

    private boolean isRepeatedSubsequence(String s, String word, int k) {
        int i = 0, count = 0;
        for (char c : s.toCharArray()) {
            if (c == word.charAt(i)) {
                i++;
                if (i == word.length()) {
                    count++;
                    if (count == k) return true;
                    i = 0;
                }
            }
        }
        return false;
    }
}
