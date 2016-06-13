public class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] result = new int[amount+1];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[0] = 0;
        for(int i = 0;i <= amount;i++){
            for(int coin: coins){
                int sum = i + coin;
                if(sum <= amount && result[i] != Integer.MAX_VALUE){
                        result[sum] = Math.min(result[sum],result[i]+1);
                }
            }
        }
        return result[amount] == Integer.MAX_VALUE ? -1: result[amount];
    }
}
