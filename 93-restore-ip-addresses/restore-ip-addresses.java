class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int start, List<String> path, List<String> result) {
        if (path.size() == 4) {
            if (start == s.length()) {
                result.add(String.join(".", path));
            }
            return;
        }

        for (int len = 1; len <= 3; len++) {
            if (start + len > s.length()) break;

            String part = s.substring(start, start + len);
            if (!isValid(part)) continue;

            path.add(part);
            backtrack(s, start + len, path, result);
            path.remove(path.size() - 1); // backtrack
        }
    }

    private boolean isValid(String s) {
        if (s.length() > 1 && s.startsWith("0")) return false; // no leading zero
        int val = Integer.parseInt(s);
        return val >= 0 && val <= 255;
    }
}
