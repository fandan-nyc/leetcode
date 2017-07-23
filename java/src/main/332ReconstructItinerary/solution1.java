public class Solution {
    private   Map<String, PriorityQueue<String>> store;
    private   Stack<String> visited;
    public List<String> findItinerary(String[][] tickets) {
        store = new HashMap<>();
        visited = new Stack<>();
        for(int i = 0; i < tickets.length; i++){
            store.putIfAbsent(tickets[i][0], new PriorityQueue<String>());
            store.get(tickets[i][0]).add(tickets[i][1]);
        }
        List<String> res = new LinkedList<String>();
        dfs("JFK");
        while(visited.isEmpty() == false){
            res.add(visited.pop());
        }
        return res;
    }
    
    private void dfs(String airport){
        while(store.containsKey(airport) && store.get(airport).isEmpty() == false){
            dfs(store.get(airport).remove());
        }
        visited.push(airport);
    }
}
