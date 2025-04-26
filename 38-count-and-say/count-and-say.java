class Solution {
    public String countAndSay(int n) {
        if(n==1){
            return "1";
        }
        String prev=countAndSay(n-1);
        StringBuilder curr=new StringBuilder(); //creates a new empty,changeable String

        int count=1;
        for(int i=1;i<prev.length();i++){
            if(prev.charAt(i)==prev.charAt(i-1)){
                count++;
            }
            else{
                curr.append(count);
                curr.append(prev.charAt(i-1));
                count=1;
            }
        }
        curr.append(count);
        curr.append(prev.charAt(prev.length()-1));

        return curr.toString();
    }
}