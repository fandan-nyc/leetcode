public class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> store = constructGraph(edges);
        Set<Integer> visited = new HashSet<Integer>();
        int count = 0;
        for(int i = 0; i < n;i++){
            if(visited.contains(i)){
                continue;
            }else{
                count++;
                bfs(i, store, visited);
            }
        }
        return count;
    }
    
    private void bfs(int i, Map<Integer, List<Integer>> store, Set<Integer> visited){
        if(store.containsKey(i) == false){
            visited.add(i);
            return;
        }
        for(int j: store.get(i)){
            if(visited.contains(j)){
                continue;
            }else{
                visited.add(j);
                bfs(j, store, visited);
            }
        }
        return;
    }
    
    private Map<Integer, List<Integer>> constructGraph(int[][] edges){
        Map<Integer, List<Integer>> store = new HashMap<>();

        for(int i = 0; i < edges.length; i++){
                int node1 = edges[i][0];
                int node2 = edges[i][1];

                if(!store.containsKey(node1)){
                    store.put(node1, new ArrayList<Integer>());
                }
                if(!store.containsKey(node2)){
                    store.put(node2, new ArrayList<Integer>());
                }
                store.get(node1).add(node2);
                store.get(node2).add(node1);
        }
        return store;
    }
}
