public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int[][] requirement = new int[dungeon.length][dungeon[0].length];
        return dfs(dungeon, requirement, 0,0);
    }
    
    private int dfs(int[][] dungeon, int[][] requirement, int x, int y){
        if(requirement[x][y] != 0){
            return requirement[x][y];
        }
        if(x == dungeon.length-1 && y == dungeon[0].length-1){
            return dungeon[x][y] >= 0 ? 1: 1-dungeon[x][y];
        }
        int min = Integer.MAX_VALUE;
        // down
        if(x < dungeon.length-1){
            int down = dfs(dungeon, requirement, x+1, y);
            min = min > down ? down: min;
        }
        // right
        if(y < dungeon[0].length-1){
            int right = dfs(dungeon, requirement, x, y+1);
            min = min > right ? right : min;
        }
        
        if(dungeon[x][y]  >= min){
            min = 1;
        }else{
            min = min - dungeon[x][y];
        }
        requirement[x][y] = min;
        return min;
    }
}
