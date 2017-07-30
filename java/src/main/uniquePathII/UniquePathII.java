public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int col = obstacleGrid[0].length-1;
        int[] total = new int[col+1];
        total[0] = 1;
        for(int[] row :obstacleGrid ){
            for(int j = 0; j <= col; j++){
                if(row[j] ==  1){
                    total[j] = 0;
                }else if(j > 0){
                    total[j] += total[j-1];
                }
            }
        }
        return total[col];
    }
}
