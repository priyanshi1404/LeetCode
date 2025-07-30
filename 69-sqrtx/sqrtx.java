class Solution {
    public int mySqrt(int x) {
        if (x < 2) return x;  // quick answer for 0 and 1

        int left = 1, right = x, ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if ((long) mid * mid <= x) {
                ans = mid;     // this could be the answer
                left = mid + 1; // look for bigger candidate
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }
}
