public class Solution {
    private int[][] moves = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int numIslands(char[][] grid) {
        int total = 0;
        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0 )
        {
            return total;
        }
        int j = grid[0].length ;
        int i = grid.length;
        boolean[][] visited = new boolean[i][j];
        for(int x = 0; x < i; x++)
            for(int y = 0; y < j; y++)
            {
                if(grid[x][y] == '1' && visited[x][y] == false)
                {
                    dfs(grid, x,y, visited);
                    total ++;
                }
            }
        return total;
    }
    
    private void dfs(char[][]grid, int x, int y, boolean[][] visited)
    {
        visited[x][y] = true;
        for(int[] move: moves)
        {
            int xx = x + move[0];
            int yy = y + move[1];
            if(xx >= 0 && xx < grid.length && yy >=0 && yy< grid[0].length && grid[xx][yy] == '1' && visited[xx][yy] == false)
            {
                dfs(grid, xx,yy,visited);
            }
        }
    }
}
