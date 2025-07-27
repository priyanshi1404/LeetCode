class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(isFound(board, word,i,j)){
                    return true;
                }
            }
        }
        return false;
    }

    //creating array for directions
    int directions[][]={{1,0},{0,1},{-1,0},{0,-1}};
    //if word exists in board or not
    boolean isFound(char[][] board, String word,int row, int col){
        //base case
        if(word.length() == 0){
            return true;
        }
        //negative base case
        if(row<0 || col<0 || col>=board[0].length || row>=board.length || board[row][col] != word.charAt(0)){
            return false;
        }
        //mark visited
        board[row][col]='#';
        //move in all directions
        boolean isMatch= false;
        for(int direction=0; direction<directions.length; direction++){
            int nextRow= directions[direction][0];
            int nextCol= directions[direction][1];

            //recursive call
            isMatch= isFound(board, word.substring(1), row+nextRow, col+nextCol);
            if(isMatch){
                break;
            }
        }
         //stack fall(backtrack) undo the '#'
            board[row][col]= word.charAt(0);
            return isMatch;
    }
}