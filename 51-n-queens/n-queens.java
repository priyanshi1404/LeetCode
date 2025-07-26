class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];

        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        backtrack(0, board, result, new HashSet<>(), new HashSet<>(), new HashSet<>());
        return result;
    }

    private void backtrack(int row, char[][] board, List<List<String>> result,
                           Set<Integer> cols, Set<Integer> diag1, Set<Integer> diag2) {
        int n = board.length;
        if (row == n) {
            result.add(buildBoard(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            int d1 = row - col;
            int d2 = row + col;
            if (cols.contains(col) || diag1.contains(d1) || diag2.contains(d2)) continue;

            // place queen
            board[row][col] = 'Q';
            cols.add(col); diag1.add(d1); diag2.add(d2);

            backtrack(row + 1, board, result, cols, diag1, diag2);

            // remove queen (backtrack)
            board[row][col] = '.';
            cols.remove(col); diag1.remove(d1); diag2.remove(d2);
        }
    }

    private List<String> buildBoard(char[][] board) {
        List<String> layout = new ArrayList<>();
        for (char[] row : board) {
            layout.add(new String(row));
        }
        return layout;
    }
}
