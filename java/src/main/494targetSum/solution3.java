public class Solution {
    private int[][] store ;
    public int findTargetSumWays(int[] nums, int S) {
       // DP
       LinkedList<Integer> queue = new LinkedList<>();
       int[][] dp = new int[nums.length][2001];
       dp[0][nums[0]+1000] +=1;
       dp[0][-nums[0]+1000] +=1;
       for(int i = 1; i < nums.length; i++){
           for(int j =0; j < 2001; j++){
               if(dp[i-1][j] != 0){
                    int prevCount = dp[i-1][j];
                    dp[i][j + nums[i]] += prevCount;
                    dp[i][j - nums[i]] += prevCount;
                }
           }
       }
       if( S > 1000 || S < -1000){
           return 0;
       }
       return dp[nums.length-1][S+1000];
    }
}
