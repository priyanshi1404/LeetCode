class Solution {
    public int findComplement(int num) {
        //step 01-count length of bits
        int numberOfBits=Integer.toBinaryString(num).length();
        int mask=(1<< numberOfBits) - 1;
        return num ^ mask;
    }
}