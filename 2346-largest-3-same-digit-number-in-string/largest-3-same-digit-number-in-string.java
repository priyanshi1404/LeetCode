class Solution {
    public String largestGoodInteger(String num) {
        String max = "";
        for (int i = 0; i <= num.length() - 3; i++) {
            char c = num.charAt(i);
            if (num.charAt(i+1) == c && num.charAt(i+2) == c) {
                String candidate = num.substring(i, i + 3);
                if (max.equals("") || candidate.compareTo(max) > 0) {
                    max = candidate;
                }
            }
        }
        return max;
    }
}
