class Solution {
    public boolean reorderedPowerOf2(int n) {
        String target = sortDigits(n);
        
        for (int i = 0; i < 31; i++) { // since 2^30 < 10^9
            int powerOfTwo = 1 << i;
            if (target.equals(sortDigits(powerOfTwo))) {
                return true;
            }
        }
        return false;
    }

    private String sortDigits(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        java.util.Arrays.sort(arr);
        return new String(arr);
    }
}
