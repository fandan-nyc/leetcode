class Solution {
    public int getMoneyAmount(int n) {
      int[][]dp = new int[n+1][n+1];
      return helper(1, n, dp);
    }
    
    private int helper(int start, int end, int[][] dp){
        if( start >= end){
            return 0;
        }
        if(dp[start][end] != 0){
            return dp[start][end];
        }
        
        int res = Integer.MAX_VALUE;
        int middle = start + (end - start) /2;
        for(int i = middle; i <= end; i++){
            res = Math.min(res, i + Math.max(helper(start, i-1, dp), helper(i+1, end,dp)));
        }
        dp[start][end] = res;
        return res;
    }
}
