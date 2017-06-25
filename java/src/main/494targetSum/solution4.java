public class Solution {
    private int[][] store ;
    public int findTargetSumWays(int[] nums, int S) {
       // DP
       LinkedList<Integer> queue = new LinkedList<>();
       int[] dp = new int[2001];
       dp[nums[0]+1000] +=1;
       dp[-nums[0]+1000] +=1;
       for(int i = 1; i < nums.length; i++){
           int[] next = new int[2001];
           for(int j =0; j < 2001; j++){
               if(dp[j] != 0){
                    int prevCount = dp[j];
                    next[j + nums[i]] += prevCount;
                    next[j - nums[i]] += prevCount;
                }
           }
           dp = next;
       }
       if( S > 1000 || S < -1000){
           return 0;
       }
       return dp[S+1000];
    }
}
