class Solution {
    boolean visited[];
    boolean inStack[];
    Map<Integer, List<Integer>> graph;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new boolean[numCourses];
        inStack = new boolean[numCourses];
        graph = prepareGraph(prerequisites);
        for(int i = 0; i < numCourses; i++){
            if(visited[i] == false){
                if(hasCircle(i, visited, inStack)){
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean hasCircle(int i, boolean[] visited, boolean[] inStack){
        // return true if there is circle
        boolean res = false;
        if(!visited[i]){
            inStack[i] = true;
            visited[i] = true;
            if(graph.containsKey(i)){
                for(int j: graph.get(i)){
                    if(!visited[j] && hasCircle(j, visited, inStack)){
                        res =  true;
                    }else if(inStack[j]){
                        res = true;
                    }
                }
            }
        }
        inStack[i] = false;
        return res;
    }
    
    private Map<Integer, List<Integer>> prepareGraph(int[][] pre){
        Map<Integer, List<Integer>> data = new HashMap<>();
        for(int[] i: pre){
            data.putIfAbsent(i[1], new ArrayList<Integer>());
            data.get(i[1]).add(i[0]);
        }
        return data;
    }
}
