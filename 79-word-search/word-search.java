class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length, cols = board[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (dfs(board, word, 0, r, c)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int index, int r, int c) {
        // Out of bounds or character mismatch
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || 
            board[r][c] != word.charAt(index)) {
            return false;
        }

        // All characters matched
        if (index == word.length() - 1) {
            return true;
        }

        // Mark current cell as visited
        char temp = board[r][c];
        board[r][c] = '#'; // Use '#' to mark as visited

        // Explore in 4 directions
        boolean found = dfs(board, word, index + 1, r + 1, c) ||
                        dfs(board, word, index + 1, r - 1, c) ||
                        dfs(board, word, index + 1, r, c + 1) ||
                        dfs(board, word, index + 1, r, c - 1);

        board[r][c] = temp; // Backtrack (restore cell)

        return found;
    }
}
