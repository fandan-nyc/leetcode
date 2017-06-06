public class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> store = new HashMap<>();
        for(int i = 0; i < ppid.size(); i++){
            if(!store.containsKey(ppid.get(i))){
                store.put(ppid.get(i), new ArrayList<Integer>());
            }
            store.get(ppid.get(i)).add(pid.get(i));
        }
        List<Integer> result = new ArrayList<>();
        findKillingProcess(store, result,kill);
        return result;
    }
    
    private void findKillingProcess(Map<Integer, List<Integer>> data, List<Integer> result, int start){
        result.add(start);
        if(data.containsKey(start) == false){
            return;
        }
        for(int i: data.get(start)){
            findKillingProcess(data, result, i);
        }
    }
    
}
