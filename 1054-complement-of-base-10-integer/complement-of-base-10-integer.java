class Solution {
    public int bitwiseComplement(int n) {
        if (n == 0) return 1;

        int bitLength = (int)(Math.log(n) / Math.log(2)) + 1;
        int mask = (1 << bitLength) - 1;

        return n ^ mask;
    }
}
