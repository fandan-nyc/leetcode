public class Solution {
    public int nthUglyNumber(int n) {
    	int[] dp = new int[n];
    	dp[0] = 1;
    	int p2 = 0, p3 = 0, p5 = 0;
    	for(int i  =1; i < n;i++){
    		while(dp[p2] * 2 <= dp[i-1]){
    			++p2;
    		}	
    		while(dp[p3] * 3 <= dp[i-1]){
    			++p3;
    		}
       		while(dp[p5] * 5 <= dp[i-1]){
    			++p5;
    		}
    		dp[i] = Math.min(dp[p2]*2, Math.min(dp[p3]*3, dp[p5]*5));
    	}
    	return dp[n-1];       
    }
}
