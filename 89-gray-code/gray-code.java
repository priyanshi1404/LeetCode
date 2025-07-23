class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res= new ArrayList<>();
        int size= 1<<n; //2^n values

        for(int i=0;i<size;i++){
            res.add(i^(i>>1));  //logic used to generate gray code
        }
        return res;
    }
}