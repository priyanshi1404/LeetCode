class Solution {
    int totalPaths = 0;
    int empty = 0;
    int startX, startY;

    public int uniquePathsIII(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;

        // First: count empty squares + find start
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    empty++;
                } else if (grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                }
            }
        }

        // Start DFS
        dfs(grid, startX, startY, -1); // Start square counts as step -1
        return totalPaths;
    }

    private void dfs(int[][] grid, int x, int y, int count) {
        int rows = grid.length, cols = grid[0].length;

        // Out of bounds or obstacle
        if (x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] == -1) return;

        if (grid[x][y] == 2) {
            // Reached end → check if all cells were visited
            if (count == empty) totalPaths++;
            return;
        }

        // Mark cell as visited
        int temp = grid[x][y];
        grid[x][y] = -1; // mark visited

        dfs(grid, x + 1, y, count + 1);
        dfs(grid, x - 1, y, count + 1);
        dfs(grid, x, y + 1, count + 1);
        dfs(grid, x, y - 1, count + 1);

        // Backtrack
        grid[x][y] = temp;
    }
}
