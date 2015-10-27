public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] result  = new int[m][n];
        for(int i  = 0; i < n; i++)
        {
            result[0][i] =  grid[0][i]  + ((i== 0)? 0: result[0][i-1]);
        }
        for(int i = 1; i < m; i ++)
        {
            for(int j = 0; j < n; j++)
            {
                result[i][j] = grid[i][j] + ((j==0)?(result[i-1][j]):(Math.min(result[i-1][j],result[i][j-1])));
            }
        }
        return result[m-1][n-1];
    }
}
