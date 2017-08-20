class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        if(S > 1000 || S < -1000){
            return 0;
        }
        int[][] dp = new int[nums.length][2001];
        dp[0][nums[0] + 1000] = 1;
        dp[0][-nums[0] + 1000] += 1;
        for(int i = 1; i < nums.length; i++){
            for(int sum = -1000; sum <= 1000; sum++){
                if(dp[i-1][sum+1000] > 0){
                    dp[i][sum + nums[i] + 1000] += dp[i-1][sum + 1000];
                    dp[i][sum - nums[i] + 1000] += dp[i-1][sum + 1000];
                }
            }
        }
        return dp[nums.length-1][S+1000];
    }
}
