class Solution {
    //Approach 02
    public int maxProfit(int[] prices){
        int maxProfit=0;
        int lowestPrice=prices[0]; //Day 1 buying price
        for(int i=1;i<prices.length;i++){
            if(prices[i]>lowestPrice){
                int profit=prices[i]-lowestPrice;
                maxProfit=Math.max(profit,maxProfit);
            }
            lowestPrice=Math.min(prices[i],lowestPrice);
        }
        return maxProfit;

    }
    //Approach-01 brute force TC O(N^2)
    // public int maxProfit(int[] prices) {
    //     int maxProfit=0;
    //     for(int buyDay=0;buyDay<prices.length;buyDay++){
    //         for(int sellDay=buyDay+1;sellDay<prices.length;sellDay++){
    //             if(prices[sellDay]>prices[buyDay]){
    //                 int profit=prices[sellDay]-prices[buyDay];
    //                 maxProfit=Math.max(profit,maxProfit);
    //             }
    //         }
    //     }
    //     return maxProfit;
        
    // }
}