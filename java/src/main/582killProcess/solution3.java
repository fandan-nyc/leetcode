public class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> store = new HashMap<>();
        for(int i = 0; i < ppid.size(); i++){
            store.putIfAbsent(ppid.get(i), new ArrayList<Integer>());
            store.get(ppid.get(i)).add(pid.get(i));
        }
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        queue.add(kill);
        while(queue.isEmpty() == false){
            int size = queue.size();
            while(size > 0){
                int curr = queue.remove();
                size--;
                result.add(curr);
                if(store.containsKey(curr)){
                    queue.addAll(store.get(curr));
                }
            }
        }
        return result;
    }
}
