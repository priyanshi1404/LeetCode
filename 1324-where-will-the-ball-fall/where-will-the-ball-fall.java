class Solution {
    public int[] findBall(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] res = new int[n];

        for (int start = 0; start < n; start++) {
            int col = start;
            for (int row = 0; row < m; row++) {
                int dir = grid[row][col];
                col += dir; // move left (-1) or right (+1)

                // Check if ball goes out of bounds
                if (col < 0 || col >= n) {
                    col = -1;
                    break;
                }

                // Check if V-shape trap occurs
                if (grid[row][col] != dir) {
                    col = -1;
                    break;
                }
            }
            res[start] = col;
        }

        return res;
    }
}
