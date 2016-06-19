public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] store = new List[numCourses];
        for(int[] i: prerequisites){
            if(store[i[1]] == null){
                store[i[1]] = new ArrayList<Integer>();
            }
            store[i[1]].add(i[0]);
        }
       int[] visited = new int[numCourses];
       Stack<Integer> stack = new Stack<>();
       int[] result = new int[numCourses];
       for(int i = 0; i < numCourses; i++){
           if(!dfs(i,stack,store, visited)){
               return new int[0];
           }
       }
       for(int i = 0; i < numCourses; i ++){
           result[i] = stack.pop();
       }
        return result ;
    }
    
    private boolean dfs(int i, Stack<Integer> stack, List<Integer>[] store, int[] visited){
       if(visited[i] == 1 ){
           return false;
       }else if(visited[i] == 2){
           return true;
       }
       visited[i] = 1;
       if(store[i] != null){
           for(int k: store[i]){
               if(!dfs(k, stack, store, visited)){
                   return false;
               }
           }
       }
       visited[i] = 2;
       stack.push(i);
       return true;
    }
}
