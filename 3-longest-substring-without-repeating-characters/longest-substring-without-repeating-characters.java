class Solution {
    public int lengthOfLongestSubstring(String s) {

        int max=0;
        int left=0;
        Set<Character> set= new HashSet<>();

        for(int right=0; right<s.length();right++){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            max=Math.max(max, right-left+1);
        }
        return max;
        // Set<Character> set = new HashSet<>();
        // int maxLen = 0;
        // int start = 0;

        // for (int end = 0; end < s.length(); end++) {
        //     char c = s.charAt(end);
        //     while (set.contains(c)) {
        //         set.remove(s.charAt(start));
        //         start++;
        //     }
        //     set.add(c);
        //     maxLen = Math.max(maxLen, end - start + 1);
        // }

        // return maxLen;
    }
}
