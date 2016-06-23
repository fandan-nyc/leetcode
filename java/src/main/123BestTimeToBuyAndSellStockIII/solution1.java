public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2){
            return 0;
        }
         int min = prices[0];
        int[] forward = new int[prices.length];
        for(int i = 1; i < prices.length; i++){
            forward[i] = Math.max(forward[i-1], prices[i] - min);
            min = Math.min(prices[i], min);
        }
        int[] backward = new int[prices.length];
        backward[prices.length -1] = 0;
        int max = prices[prices.length-1];
        for(int i = prices.length-2;i >= 0 ; i--){
            backward[i] = Math.max(backward[i+1], max - prices[i]);
            max = Math.max(prices[i], max);
        }
        int result = 0;
        for(int i = 0;  i < prices.length; i++){
            result = Math.max(result, backward[i] + forward[i]);
        }
        return result ;
        
    }
}
