class Solution {
    public void setZeroes(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;  //col

        boolean row[]=new boolean[n];
        boolean[] col= new boolean[m];

        //mark it where it is 0 in row and col
        for(int i=0;i<n;i++){
            for(int j=0; j<m; j++){
                if(matrix[i][j]==0){
                    row[i]=true;
                    col[j]=true;
                }
            }
        }

        //now its time to apply 0(fill)
        for(int i=0;i<n;i++){
            for(int j=0; j<m; j++){
                if(row[i] || col[j]){
                    matrix[i][j]=0;
                }
            }
        }

    }
}