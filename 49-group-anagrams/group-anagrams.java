class Solution {
    boolean isAnagram(String first,String second){
        if(first.length()!=second.length()){
            return false;
        }
        char[] x=first.toCharArray();
        char[] y=second.toCharArray();
        Arrays.sort(x);
        Arrays.sort(y);
        return Arrays.equals(x,y); //if same so it returns true otherwise returns false
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> bigList=new ArrayList<>();
        for(String word:strs){
            boolean added=false; //flag to check if it is already in the list
            for(List<String> smallList: bigList){
                if(isAnagram(smallList.get(0),word)){
                   smallList.add(word);
                   added=true;
                   break;
                }
            }
            if(!added){
                List<String> newSmallList=new ArrayList<>();
                newSmallList.add(word);
                bigList.add(newSmallList);
            }
        }
        return bigList;
    }
}