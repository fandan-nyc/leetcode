public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        final int m =  obstacleGrid.length;
        final int n = obstacleGrid[0].length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int i = 0; i < obstacleGrid[0].length; i++){
            if(obstacleGrid[0][i] == 1 || (i > 0 && dp[i-1]== 0)){
                dp[i]= 0;
            }
        }
        for(int i = 1; i < m; i ++){
            for(int j = 0; j < n; j++){
                if(obstacleGrid[i][j] == 1){
                    dp[j] = 0;
                }else if(j > 0){
                    dp[j] = dp[j-1] + dp[j];
                }
            }
        }
        return dp[n-1];
    }
}
