public class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for(int i: nums){
            total += i;
        }
        if(total %2 == 1 ){
            return false;
        }
        total /= 2; 
        boolean[][] dp = new boolean[nums.length+1][total+1];

        dp[0][0] = true;
        // col 
        for(int i = 0; i < nums.length; i++){
            dp[i][0] = true;
        }
        for(int i = 1; i <= nums.length; i++){
            for(int j = 1; j < total+1; j++){
                dp[i][j] = dp[i-1][j];
                if(j >= nums[i-1]){
                    dp[i][j] = dp[i][j] || dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[nums.length][total];
    }
}
