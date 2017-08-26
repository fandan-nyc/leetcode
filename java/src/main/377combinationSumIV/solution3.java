class Solution {
    public int combinationSum4(int[] nums, int target) {
       int[] dp = new int[target+1];
        dp[0] = 1;
        for(int i = 1; i <= target; i++){
            for(int j: nums){
                if(i >= j){
                    dp[i] += dp[i-j];
                }
            }
        }
        return dp[target];
    }
}
