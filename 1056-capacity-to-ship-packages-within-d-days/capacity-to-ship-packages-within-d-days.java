class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;  // minimum possible capacity
        int right = 0; // maximum possible capacity

        for (int w : weights) {
            left = Math.max(left, w);  // at least the heaviest package
            right += w;                // at most, all packages in one day
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canShip(weights, days, mid)) {
                right = mid;  // try smaller capacity
            } else {
                left = mid + 1;  // need bigger capacity
            }
        }

        return left;
    }

    private boolean canShip(int[] weights, int days, int capacity) {
        int currentLoad = 0;
        int dayCount = 1;

        for (int w : weights) {
            if (currentLoad + w > capacity) {
                dayCount++;      // new day
                currentLoad = 0; // reset load
            }
            currentLoad += w;
        }

        return dayCount <= days;
    }
}
