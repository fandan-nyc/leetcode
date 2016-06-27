public class Solution {
    public int maxCoins(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int[] number = new int[nums.length+2];
        number[0] =1;
        number[nums.length+1] = 1;
        for(int i = 0; i < nums.length; i++){
            number[i+1] = nums[i];
        }
        int[][] dp = new int[nums.length+2][nums.length+2];
        for(int i = 1; i < number.length-1; i++){
            for(int j = i; j >= 1; j--){
                for(int k = j; k <= i; k++){
                    dp[j][i] = Math.max(dp[j][i], dp[j][k-1] + dp[k+1][i] + number[j-1]*number[i+1]*number[k]);
                }
            }
        }
        return dp[1][number.length-2];
    }
}
