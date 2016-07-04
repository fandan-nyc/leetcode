/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // BFS
        if(node == null){
            return null;
        }
        UndirectedGraphNode result = new UndirectedGraphNode(node.label);
        Queue<UndirectedGraphNode> queue =  new LinkedList<UndirectedGraphNode>();
        Map<Integer, UndirectedGraphNode> visited = new HashMap<>();
        visited.put(node.label, result);
        queue.add(node);
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                UndirectedGraphNode tmp = queue.poll();
                for(UndirectedGraphNode neigh : tmp.neighbors){
                    if(!visited.containsKey(neigh.label)){
                        queue.add(neigh);
                        visited.put(neigh.label, new UndirectedGraphNode(neigh.label));
                    }
                    visited.get(tmp.label).neighbors.add(visited.get(neigh.label));
                }
                size--;        
            }
        }
        return result;
    }
}
