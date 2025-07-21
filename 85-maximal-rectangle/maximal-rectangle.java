class Solution {
    public int maximalRectangle(char[][] matrix) {
        int max=0;
       if(matrix.length==0){
        return 0;
       }

       int height[]=new int[matrix[0].length];
       for(int i=0;i<matrix.length;i++){
        for(int j=0;j<matrix[0].length;j++){
            if(matrix[i][j] =='0'){
                height[j]=0;
            }
            else{
                height[j]+=1;
            }
        }
               max=Math.max(max,findTheArea(height));
       }
       return max;
    }
    public int findTheArea(int[] h){
        int max=0;
        Stack<Integer> stack= new Stack<>();
        stack.add(0);
        for(int i =0;i<h.length;i++){
            int curr=h[i];
            if(stack.isEmpty() || curr>=h[stack.peek()]){
                stack.add(i);
            }
            else{
                while(!stack.isEmpty() && curr<h[stack.peek()]){
                   int temp=h[stack.pop()];
                   if(stack.isEmpty()){
                    max=Math.max(max,temp*i);
                   }
                   else{
                    max=Math.max(max,temp*(i-stack.peek()-1));
                   }
                }
                stack.add(i);
            }
        }
        if(!stack.isEmpty()){
            while(!stack.isEmpty()){
                   int i=h.length;
                   int temp=h[stack.pop()];
                   if(stack.isEmpty()){
                    max=Math.max(max,temp*i);
                   }
                   else{
                    max=Math.max(max,temp*(i-stack.peek()-1));
                   }
                }
        }
        return max;
    }
}