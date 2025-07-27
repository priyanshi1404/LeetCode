class Solution {
    //making a combination array
    String[] keys={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};  //starting from 0.  0-blank, 1- blank, starting from 2
    public List<String> letterCombinations(String digits) {
        if(digits.length() ==0){
            return new ArrayList<>();
        }
        else{
            return helper(digits);
        }
    }
    public List<String> helper(String digits) {
        //base case
        if(digits.length()==0){
            List<String> list = new ArrayList<>();
            list.add("");  //making it traversable
            return list;
        }
        //new list
        List<String> newList = new ArrayList<>();

        char firstDigit = digits.charAt(0);
        int index= firstDigit - '0';
        String str= keys[index];
        //e.g traverse abc
        for(int i=0; i<str.length(); i++){
            //small problem
           List<String> oldList= helper(digits.substring(1));
           for(int j=0; j<oldList.size(); j++){
            newList.add(str.charAt(i) + oldList.get(j));
           }
        }
        return newList;
    }
}