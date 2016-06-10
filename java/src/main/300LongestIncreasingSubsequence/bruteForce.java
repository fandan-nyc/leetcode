public class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length <=0){
            return 0;
        }
        int[] dp = new int[nums.length];
        int max = 1; 
        for(int i = nums.length-1; i >=0; i --){
            int tmpMax =1 ;
            for(int j= i +1; j < nums.length; j++){
               if(nums[j] > nums[i]){
                   tmpMax= Math.max(1+dp[j],tmpMax);
               }
            }
            dp[i] = tmpMax;
        }
        for(int i = 0; i < dp.length; i++){
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
