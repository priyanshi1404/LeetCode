class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0) return new int[0];
        
        int m = mat.length, n = mat[0].length;
        int[] result = new int[m * n];
        
        int row = 0, col = 0, dir = 1; // dir=1 means moving up-right, dir=-1 means down-left
        int idx = 0;
        
        while (idx < m * n) {
            result[idx++] = mat[row][col];
            
            if (dir == 1) { // moving up-right
                if (col == n - 1) { // hit right boundary
                    row++;
                    dir = -1;
                } else if (row == 0) { // hit top boundary
                    col++;
                    dir = -1;
                } else {
                    row--;
                    col++;
                }
            } else { // moving down-left
                if (row == m - 1) { // hit bottom boundary
                    col++;
                    dir = 1;
                } else if (col == 0) { // hit left boundary
                    row++;
                    dir = 1;
                } else {
                    row++;
                    col--;
                }
            }
        }
        
        return result;
    }
}
