public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] result = new int[m][n];
        for(int i = 0; i < m ;i++)
        {
            result[i][0] = 1;
        }
        for(int i = 0; i < n ; i++)
        {
            result[0][i] = 1;
        }
        for(int i = 1;i < m; i++)
        {
            for(int j=1;j<n;j++)
            {
                result[i][j] = result[i-1][j]+ result[i][j-1];
            }
        }
        return result[m-1][n-1];        
    }
}
