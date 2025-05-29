class Solution {
    //Approach -Two Pointer

    boolean isVowels(char ch){
        return "aeiouAEIOU".indexOf(ch)>=0;
    }
    public String reverseVowels(String s) {
        int i=0;
        int j=s.length()-1;
        char arr[]=s.toCharArray(); //String(immutable) convert to char[](mutable)
        while(i<=j){
            if(!isVowels(arr[i])){
                i++;
            }
            else if(!isVowels(arr[j])){
                j--;
            }
            else{
                //it means vowel therefore swap it
                char temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
                j--;
            }
        }
        return new String(arr);  //convert char[] into String
        
    }
}