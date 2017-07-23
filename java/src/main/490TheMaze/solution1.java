public class Solution {
    private int[][] visited ;
    public boolean hasPath(int[][] maze, int[] start, int[] des) {
        visited = new int[maze.length][maze[0].length];
        return dfs(maze, start, des);
    }
    
    private boolean dfs(int[][] maze, int[] start, int[] des){
        if(isVisited(start)){
            return false;
        }
        if(isArriveDes(start, des)){
            return true;
        }
        visit(start);
        int[] right = move(maze, start, des, "RIGHT");
        if(dfs(maze, right, des)){
            return true;
        }
        int[] left = move(maze, start, des, "LEFT");
        if(dfs(maze, left, des)){
            return true;
        } 
        int[] up = move(maze, start, des, "UP");
        if(dfs(maze, up, des)){
            return true;
        } 
        int[] down = move(maze, start, des, "DOWN");
        if(dfs(maze, down, des)){
            return true;
        }
        return false;
    }
    
    private int[] move(int[][] maze, int[] start, int[] des, String direction){
        int a = start[0];
        int b = start[1];
        if(direction.equals("RIGHT")){
            while(b < maze[0].length && maze[a][b] != 1){
                b++;
            }
            b--;
        }else if(direction.equals("LEFT")){
            while(b >=0 && maze[a][b] != 1){
                b--;
            }
            b++;
        }else if(direction.equals("DOWN")){
            while(a < maze.length && maze[a][b] != 1){
                a++;
            }
            a--;
        } else if(direction.equals("UP")){
            while(a >=0 && maze[a][b] != 1){
                a--;
            }
            a++;
        }else {
            throw new IllegalArgumentException("only UP DOWN RIGHT LEFT are allowed");
        }
        return new int[]{a,b};
    }
    
    private boolean isVisited(int[] a){
        return visited[a[0]][a[1]] == -1;
    }
    
    private void visit(int[] a){
        visited[a[0]][a[1]] = -1;
    }
    
    private boolean isArriveDes(int[] start, int[] des){
        return start[0] == des[0] && start[1] == des[1];
    }
}
