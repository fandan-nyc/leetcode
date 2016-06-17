public class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0  || matrix[0].length == 0){
            return 0;
        }
        int[][] dp = new int[matrix.length][matrix[0].length];
        
        int max = 0;
        int left; 
        int up;
        int upperLeft ;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == '0'){
                    dp[i][j] = 0;
                }else if(i == 0 || j == 0){
                    dp[i][j] = matrix[i][j] == '0' ? 0 :1;
                }else{
                    left =  dp[i][j-1];
                    up =    dp[i-1][j];
                    upperLeft = dp[i-1][j-1];
                    dp[i][j] = Math.min(left, Math.min(up, upperLeft))+1;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max*max;

    }
}
