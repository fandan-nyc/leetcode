public class Solution {
    int[] parent ;
    public int countComponents(int n, int[][] edges) {
        parent= prepareParent(n);

        for(int i = 0; i < edges.length; i++){
            union(edges[i][0], edges[i][1]);
        }
        Set<Integer> visited =  new HashSet<>();
        for(int i = 0; i < n; i++){
            visited.add(find(i));
        }
        return visited.size();
       
    }
    
    private int[] prepareParent(int n){
        int[] parent = new int[n];
        int i = 0; 
        while(i < n){
            parent[i] = i;
            i++;
        }
        return parent;
    }
    
    private void union(int a, int b){
        parent[find(a)] = find(b);
    }
    
    private int find(int i){
        if(parent[i] == i){
            return i;
        }
        parent[i] = find(parent[i]);
        return parent[i];
    }
}
