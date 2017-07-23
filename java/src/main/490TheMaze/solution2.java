public class Solution {
    private int[][] visited ;
    private Queue<int[]> queue ; 
    private List<int[]> directions ; 
    public boolean hasPath(int[][] maze, int[] start, int[] des) {
        visited = new int[maze.length][maze[0].length];
        queue = new LinkedList<int[]>();
        directions = Arrays.asList(new int[]{-1,0}, new int[]{1,0}, new int[]{0,1}, new int[]{0,-1});
        queue.add(start);
        while(!queue.isEmpty()){
            int[] point = queue.remove();
            if(isVisited(point)){
                continue;
            }
            visit(point);
            if(reachDes(point, des)){
                return true;
            }
            bfs(maze, point, des);
        }
        return false;
        
    }
    
    private void bfs(int[][] maze, int[] point, int[] des){
        for(int[] dir : directions){
            int[] tmp = move(maze, point, dir);
            queue.add(tmp);
        }
    }
    
    private boolean reachDes(int[] point, int[] des){
        return point[0] == des[0] && point[1] == des[1];
    }
    
    private int[] move(int[][] maze, int[] input, int[] direction){
       int[] tmp =  new int[]{input[0], input[1]};
        while(inRange(tmp, maze) && maze[tmp[0]][tmp[1]] != 1){
            tmp[0] += direction[0];
            tmp[1] += direction[1];
        }
        tmp[0] -= direction[0];
        tmp[1] -= direction[1]; 
        return tmp;
    }
    
    private boolean inRange(int[] a, int[][] maze){
        return a[0] >= 0 && a[1] >= 0 && a[0] < maze.length && a[1] < maze[0].length;
    }
    
    
    private boolean isVisited(int[] a){
        return visited[a[0]][a[1]] == -1;
    }
    
    private void visit(int[]a){
        visited[a[0]][a[1]] = -1;
    }
    
}
