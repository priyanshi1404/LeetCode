// class Solution{
//     public int fib(int n){
        
//     }
// }



class Solution {
    Map<Integer,Integer>cache=new HashMap<>();
    //DP Approach-Top to Down approach
    public int fib(int n) {
       if(n==0 || n==1){
        return n;
       } 
       //before compute, first check in cache
       if(cache.containsKey(n)){
        return cache.get(n);
       }
       int result=fib(n-1)+fib(n-2);
       cache.put(n,result);
       return result;
    }
}