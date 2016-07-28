public class Solution {
    public int minPathSum(int[][] grid) {
        int[] result = new int[grid[0].length];
        result[0] = grid[0][0];
        for(int i = 1; i < result.length; i++){
            result[i] = result[i-1] + grid[0][i];
        }
        for(int i = 1; i < grid.length;i++){
            result[0] = result[0] + grid[i][0];
            for(int j = 1; j < grid[0].length; j++){
                result[j] = Math.min(result[j],result[j-1]) + grid[i][j];
            }
        }
        return result[grid[0].length-1];
    }
}
