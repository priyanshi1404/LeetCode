class Solution {
    //chess board
    boolean board[][];
    public int totalNQueens(int n) {
        board=new boolean[n][n];  //board is filled with false now
        return helper(0,n);
    }
    boolean willIPlaceAQueen(int row, int col){
        // CASE 1- above row
        for(int i=row; i>=0; i--){
            if(board[i][col]){
                return false;
            }
        }
        // CASE 2-left diagonal
        for(int i=row,j=col; i>=0 && j>=0; i--,j--){
            if(board[i][j]){
                 return false;
            }
        }
        // CASE 3-right diagonal
        for(int i=row,j=col; i>=0 && j<board[0].length; i--,j++){
            if(board[i][j]){
                 return false;
            }
        }
        return true;   //place the queen
    }
    int helper(int row, int n){
        //base case
        if(row == n){
            return 1;
        }
        int count=0;
        //try to place a queen in a column
        for(int col=0; col<n; col++){
            if(willIPlaceAQueen(row,col)){
                board[row][col] = true;
                //move to the next row and col
                count= count + helper(row+1, n);
                //Stack fall(backtrack)
                board[row][col]= false; //undo
            }
        }
        return count;
    }
}