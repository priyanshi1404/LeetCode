class Solution {
    //Approach -3
      public List<List<String>> groupAnagrams(String[] strs){
        Map<String,List<String>>map=new HashMap<>();
        for(String word: strs){
            int countArr[]=new int[26];
            for(char c:word.toCharArray()){
                countArr[c-'a']++;
            }
            StringBuilder sb=new StringBuilder();
            for(int k:countArr){
                sb.append(k).append('#'); //1#1#1#
            }
            String key=sb.toString();
            map.computeIfAbsent(key,k->new ArrayList<>()).add(word);
        }
        return new ArrayList<>(map.values());
      }

    //Approach 2-HASHING
    // public List<List<String>> groupAnagrams(String[] strs){
    //         Map<String,List<String>>map=new HashMap<>();
    //          for(String word:strs){
    //         char w[]= word.toCharArray();
    //         Arrays.sort(w);
    //         String key=new String(w);
    //         map.computeIfAbsent(key,k->new ArrayList<>()).add(word);
    //     }
    //     return new ArrayList<>(map.values());
    //  }

    // //Approach 1-Brute Force solution
    // boolean isAnagramOld(String first,String second){
    //     if(first.length()!=second.length()){
    //         return false;
    //     }
    //     char[] x=first.toCharArray();
    //     char[] y=second.toCharArray();
    //     Arrays.sort(x);
    //     Arrays.sort(y);
    //     return Arrays.equals(x,y); //if same so it returns true otherwise returns false
    // }
    // public List<List<String>> groupAnagramsOld(String[] strs) {
    //     List<List<String>> bigList=new ArrayList<>();
    //     for(String word:strs){
    //         boolean added=false; //flag to check if it is already in the list
    //         for(List<String> smallList: bigList){
    //             if(isAnagram(smallList.get(0),word)){
    //                smallList.add(word);
    //                added=true;
    //                break;
    //             }
    //         }
    //         if(!added){
    //             List<String> newSmallList=new ArrayList<>();
    //             newSmallList.add(word);
    //             bigList.add(newSmallList);
    //         }
    //     }
    //     return bigList;
    // }
}