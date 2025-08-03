class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list= new ArrayList<>();
        int m=matrix.length; //rows
        int n= matrix[0].length; //col
        //left to right
        //top to bottom
        //right to left
        //move to up
        //maintain the index
        int top=0;
        int bottom=m-1;
        int left=0;
        int right=n-1;
        while(top<=bottom && left<=right){
             //left to right
             for(int j= left;j<=right;j++){
                list.add(matrix[top][j]);
             }
             //shrink the row
             top++;
             //step02- top to bottom 
             for(int j=top; j<=bottom; j++){
                list.add(matrix[j][right]);
             }
             //shrink the right
             right--;
             //step03-right to left
             if(top<=bottom){
             for(int j=right;j>=left;j--){
                list.add(matrix[bottom][j]);
             }
             //shrink the bottom
             bottom--;
             }
             //step04- move to up
             if(left <= right){
             for(int j=bottom; j>=top; j--){
                list.add(matrix[j][left]);
             }
             left++;
             }
          
             
        }
        return list;
    }
}