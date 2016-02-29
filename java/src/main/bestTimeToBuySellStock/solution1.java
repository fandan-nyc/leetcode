public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1){
            return 0;
        }
        int[] profit = new int[prices.length-1];
        for(int i = 1; i < prices.length; i++){
            profit[i-1] = prices[i] - prices[i-1];
        }
        int[] currMax = new int[profit.length];
        currMax[0] = profit[0];
        int max = currMax[0];
        for( int i = 1; i < currMax.length; i ++){
                currMax[i] = Math.max(currMax[i-1]+ profit[i], profit[i]);
                max = Math.max(max, currMax[i]);
        }
        return max > 0 ? max: 0;
    }
}
