public class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices == null || prices.length <= 1){
            return 0;
        }
        if(k >= prices.length/2){
            int max = 0;
            for(int i = 1; i < prices.length; i++){
                int tmp =  prices[i] - prices[i-1];
                max += (tmp > 0 ? tmp: 0);
            }
            return max;
        }
        int[][] dp = new int[k+1][prices.length];
        for(int i = 1; i <= k; i++){
            int tmpMax = 0;
            // dp[i][j] = max(dp[i][j-1], max(dp[i-1][jj]+ price[j] - price[jj]) for jj in (i,j-1) 
            // dp[i][j] = max(dp[i][j-1], price[j] + max(dp[i-1][jj] - price[jj])
            int localMax = dp[i-1][0]-prices[0];
            for(int j = 1; j < prices.length; j++){
                dp[i][j] = Math.max(dp[i][j-1], prices[j] + localMax);
                localMax = Math.max(localMax, dp[i-1][j]-prices[j]);
            }
        }
        return dp[k][prices.length-1];
    }
}

