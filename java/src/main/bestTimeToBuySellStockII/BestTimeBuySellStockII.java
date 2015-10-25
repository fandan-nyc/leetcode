public class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        for(int i = 1; i < prices.length; i ++)
        {
            int profit = prices[i] - prices[i-1];
            result += profit > 0 ? profit: 0;
        }
        return result;
    }
}
