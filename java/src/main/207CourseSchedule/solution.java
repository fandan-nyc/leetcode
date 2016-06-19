public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] map = prepareMap(prerequisites, numCourses);
        int[] visited =  new int[numCourses];
        for( int i = 0; i < numCourses; i ++){
            if(map[i].isEmpty()){
                continue;
            }
            if(hasCircle(i, map, visited)){
                return false;
            }
        }
        return true;
    }
    
    private boolean hasCircle(int input, List<Integer>[] map, int[] visited){
        /*
         * the following part is import. so for the checked ones, we do not keep on checking the result.
         * without the first two if check, the code works, but we do a lot of duplicated work and it will TLE
         *
         */
        if(visited[input] == 2){
            return false;
        }
        if(visited[input] == 1){
            return true;
        }
        visited[input] = 1;
        for(int i: map[input]){
            if(visited[i] == 1){
                return true;
            }
            if(hasCircle(i, map, visited)){
                return true;
            }
        }
        visited[input] = 2;
        return false;
    }
    
    private  List<Integer>[] prepareMap(int[][] prerequisites, int num){
        List<Integer>[] result = new List[num];
        for(int i = 0; i < num; i ++){
            result[i] = new ArrayList<Integer>();
        }
        for(int[] x: prerequisites){
            result[x[0]].add(x[1]);
        }
        return result ; 
    }
}
