public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1){
            return 0;
        }
        int[] profit = new int[prices.length-1];
        for(int i = 1; i < prices.length; i++){
            profit[i-1] = prices[i] - prices[i-1];
        }
        int currMax = 0;
        int max = 0;
        for( int i = 0; i < profit.length; i ++){
                currMax = Math.max(currMax + profit[i], profit[i]);
                max = Math.max(max, currMax);
        }
        return max ;
    }
}
