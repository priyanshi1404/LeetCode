class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        boolean isSameSize=false;
        for(int i=0; i< asteroids.length; i++){
            isSameSize=false;
            while(!stack.isEmpty() && stack.peek()>0 && asteroids[i]<0){
                if(Math.abs(asteroids[i]) > stack.peek()){
                    stack.pop();
                    continue;
                }
                else if(Math.abs(asteroids[i])==stack.peek()){
                    stack.pop();
                }
                isSameSize=true;
                break;
            }
            if(!isSameSize){
                stack.push(asteroids[i]);  //push the big one in string
            }
        }
        //store the result of remanining
        int result[] = new int[stack.size()];
        for(int i=result.length-1;i>=0;i--){
            result[i]= stack.pop();
        }
        return result;
        
    }
}