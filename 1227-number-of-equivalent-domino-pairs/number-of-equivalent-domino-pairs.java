class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] count = new int[100];  // there are only 1 <= a,b <= 9, so max key is 9*10 + 9 = 99
        int result = 0;

        for (int[] d : dominoes) {
            int a = d[0], b = d[1];
            int key = a < b ? a * 10 + b : b * 10 + a; // normalize so [a,b] and [b,a] are the same
            result += count[key]; // every previous domino with same key forms a pair with this one
            count[key]++;
        }

        return result;
    }
}
