public class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> store = new HashMap<>();
        for(int i = 0; i < ppid.size(); i++){
            store.putIfAbsent(ppid.get(i), new ArrayList<Integer>());
            store.get(ppid.get(i)).add(pid.get(i));
        }
        Stack<Integer> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        stack.push(kill);
        while(stack.empty() == false){
            int curr = stack.pop();
            result.add(curr);
            if(store.containsKey(curr) == false){
                continue;
            }
            stack.addAll(store.get(curr));
        }
        return result;
    }
}
