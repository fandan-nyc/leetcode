public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int result = 0; 
        for(int i = 0 ; i < n; i++)
        {
         grid[0][i] +=  (i >= 1)?(grid[0][i-1]):0;   
        }
        for(int i = 1; i < m; i ++)
        {
            for(int j = 0; j < n; j++)
            {
                grid[i][j] += (j==0)?(grid[i-1][j]):(Math.min(grid[i-1][j],grid[i][j-1]));
            }
        }
        return grid[m-1][n-1];
    }
}
