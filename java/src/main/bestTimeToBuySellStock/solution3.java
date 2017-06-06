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
// another 
public class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int curr = 0; 
        for(int i = 1; i < prices.length; i++){
            int tmp = curr + prices[i] - prices[i-1];
            if(tmp > 0){
                curr = tmp;
                max = max > curr ? max: curr;
            }else{
                curr = 0;
            }
        }
        return max;
    }
}
