public class Solution {
    public int jump(int[] nums) {
        if(nums == null || nums.length <= 1){
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[nums.length-1] = 0;
        for(int i = nums.length-2; i >= 0; i--){
            if(nums[i] == 0){
                dp[i] = -1;
            }else if(nums[i] >= nums.length-1 -i){
                dp[i] = 1;
            }else{
                int min = -1; 
                for(int j = i+1; j <= i+nums[i] && j < nums.length;j++){
                    if(dp[j] >= 0){
                        if(min == -1){
                            min = dp[j];
                        }else{
                            min = min < dp[j] ? min: dp[j];
                        }
                    }
                }
                dp[i] = (min == -1) ? -1: (min+1);
            }
        }
        return dp[0];
    }
}
