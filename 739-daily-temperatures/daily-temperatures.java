class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //Approach 01-Brute Force  TLE beacause of the given constraints
        // int result[]= new int[temperatures.length];
        // int n=temperatures.length;
        // for(int i=0;i<n;i++){
        //     int curr=temperatures[i];
        //     for(int j=i+1;j<n;j++){
        //         if(temperatures[j] > curr){
        //             result[i]=j-i;
        //             break;
        //         }
        //     }
        // }
        // return result;
        

        //Approach 02- Using stack approach

        int result[]=new int[temperatures.length];
        int n=temperatures.length;
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.empty() && temperatures[st.peek()] <temperatures[i] ){
                Integer pop=st.pop();
                result[pop]=i-pop;
            }
            st.push(i);
        }
        return result;
    }
}