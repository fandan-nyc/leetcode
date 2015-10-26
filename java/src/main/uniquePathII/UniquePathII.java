public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n =  obstacleGrid[0].length;
        int[] result = new int[n];
        int m = obstacleGrid.length;
        for(int i = 0; i < n; i++ )
        {
            if(obstacleGrid[0][i]== 1 || (i>= 1 && result[i-1] == 0))
            {
                result[i] = 0;
            }
            else 
            {
                result[i] = 1;
            }
        }
        int i = 1;
        while(i < m)
        {
            for(int j = 0; j < n; j ++)
            {
                if(obstacleGrid[i][j] == 1)
                {
                    result[j] = 0;
                }
                else
                {
                    result[j] += (j == 0) ? 0: result[j-1];
                }
            }
            i++;
        }
        return result[n-1];
        
    }
}
