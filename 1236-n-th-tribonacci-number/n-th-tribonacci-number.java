class Solution {
    public int helper(int n, Integer cache[]){
        if(n==0){
            return 0;
        }
        if(n==1 || n==2){
            return 1;
        }
        if(cache[n]!=null){
            return cache[n];

        }
        cache[n]= helper(n-1,cache) + helper(n-2,cache) + helper(n-3,cache);
        return cache[n];
    }
    public int tribonacci(int n) {
        //memoization
        Integer[] cache=new Integer[n+1];
        return helper(n,cache);
        
    }
}