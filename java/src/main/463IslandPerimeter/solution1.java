public class Solution {
    public int islandPerimeter(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int total = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] ==1){
                    total += 4;
                    if(i > 0){
                        total -= (grid[i-1][j]==1) ? 2:0;
                    }
                    if(j > 0){
                        total -= (grid[i][j-1]==1) ? 2:0;
                    }
                }
            }
        }
        return total;
    }
}
