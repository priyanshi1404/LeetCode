/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();

        // Step 1: Find peak index
        int peak = findPeakIndex(mountainArr, n);

        // Step 2: Binary search on the left side (ascending)
        int index = binarySearch(mountainArr, target, 0, peak, true);
        if (index != -1) return index;

        // Step 3: Binary search on the right side (descending)
        return binarySearch(mountainArr, target, peak + 1, n - 1, false);
    }

    // Find peak index using binary search
    private int findPeakIndex(MountainArray mountainArr, int n) {
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int midVal = mountainArr.get(mid);
            int midNext = mountainArr.get(mid + 1);
            if (midVal < midNext) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left; // or right
    }

    // Binary search helper
    private int binarySearch(MountainArray mountainArr, int target, int left, int right, boolean asc) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midVal = mountainArr.get(mid);
            if (midVal == target) return mid;

            if (asc) {
                if (midVal < target) left = mid + 1;
                else right = mid - 1;
            } else {
                if (midVal > target) left = mid + 1;
                else right = mid - 1;
            }
        }
        return -1;
    }
}
