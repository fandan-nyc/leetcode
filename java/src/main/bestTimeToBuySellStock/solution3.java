public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < min){
                min = prices[i];
            }
            int curr = prices[i] - min;
            maxProfit = maxProfit > curr ? maxProfit: (curr);
        }
        return maxProfit;
    }
}
