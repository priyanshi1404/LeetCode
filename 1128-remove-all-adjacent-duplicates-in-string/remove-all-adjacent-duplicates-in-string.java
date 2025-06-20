class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        char letters[] = s.toCharArray();
        for(char letter: letters){
            if(stack.size()>0 && stack.peek() == letter){
                stack.pop();
            }
            else{
                stack.push(letter);
            }
        }
        String result="";
        while(!stack.isEmpty()){
            result+=stack.pop();
        }
        return new StringBuilder(result).reverse().toString();
        
    }
}