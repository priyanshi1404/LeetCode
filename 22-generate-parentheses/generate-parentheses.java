class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        helper(0,0,0, "",res,n);
        return res;
        
    }
    void helper(int opening, int closing, int index, String output, List<String> result, int n){
        //base case
        if(index == n*2){
            result.add(output);
            return;
        }
        //rule-1 opening<n (Can I place opening)
        if(opening < n){
            helper(opening+1, closing, index+1, output+'(', result, n);
        }
        //rule-2 closing<opening (Can I place closing)
        if(closing < opening){
            helper(opening, closing+1, index+1, output+')', result, n);
        }
    }
}