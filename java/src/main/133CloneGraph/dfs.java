/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    private Map<Integer, UndirectedGraphNode> visited =  new HashMap<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // DFS
        if(node == null){
            return null;
        }
        if(visited.containsKey(node.label)){
            return visited.get(node.label);
        }
        UndirectedGraphNode result = new UndirectedGraphNode(node.label);
        visited.put(node.label, result);
        for(UndirectedGraphNode neigh: node.neighbors){
            result.neighbors.add(cloneGraph(neigh));
        }
        return result;
    }
}
