class Solution {
    static class TrieNode{
        TrieNode[] children= new TrieNode[2];  //for 0 and 1 
    }
    TrieNode root = new TrieNode();
    private void buildTrie(int[] nums){
        for(int num:nums){
            TrieNode currNode=root;
            for(int i=31;i>=0;i--){
                int curBit=(num>>i)&1;
                if(currNode.children[curBit] == null){
                    currNode.children[curBit]= new TrieNode();
                }
                currNode = currNode.children[curBit];
            }
        }
    }

    private int findMaxXor(int num){
         TrieNode currNode = root;
            int currXor = 0;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                int toggled = 1 - bit; // opposite bit
                if (currNode.children[toggled] != null) {
                    currXor |= (1 << i); // set this bit in result
                    currNode = currNode.children[toggled];
                } else {
                    currNode = currNode.children[bit];
                }
            }
                return currXor;
        }
    public int findMaximumXOR(int[] nums) {
        //checking for null condition
        if(nums== null || nums.length==0){
            return 0;
        }
        buildTrie(nums);
        int max=0;
        for(int num:nums){
            int maxForXor= findMaxXor(num);
            max=Math.max(max,maxForXor);
        }
        return max;
    }
}