class Solution {
    private int[] segTree;
    private int n;

    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        n = baskets.length;
        segTree = new int[4 * n];
        build(baskets, 0, n - 1, 1);

        int unplaced = 0;
        for (int fruit : fruits) {
            if (placeFruit(fruit, 0, n - 1, 1) == -1) {
                unplaced++;
            }
        }
        return unplaced;
    }

    private void build(int[] arr, int lo, int hi, int idx) {
        if (lo == hi) {
            segTree[idx] = arr[lo];
        } else {
            int mid = (lo + hi) / 2;
            build(arr, lo, mid, 2 * idx);
            build(arr, mid + 1, hi, 2 * idx + 1);
            segTree[idx] = Math.max(segTree[2 * idx], segTree[2 * idx + 1]);
        }
    }

    private int placeFruit(int fruit, int lo, int hi, int idx) {
        if (segTree[idx] < fruit) return -1;
        if (lo == hi) {
            segTree[idx] = -1;  // mark basket used
            return lo;
        }
        int mid = (lo + hi) / 2;
        int res;
        if (segTree[2 * idx] >= fruit) {
            res = placeFruit(fruit, lo, mid, 2 * idx);
        } else {
            res = placeFruit(fruit, mid + 1, hi, 2 * idx + 1);
        }
        segTree[idx] = Math.max(segTree[2 * idx], segTree[2 * idx + 1]);
        return res;
    }
}
