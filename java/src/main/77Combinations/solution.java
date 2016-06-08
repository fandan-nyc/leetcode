public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        helper(n, k, 1, result, new LinkedList<Integer>());
        return result;
    }
    
    private void helper(int n, int k, int start,  List<List<Integer>> result, LinkedList<Integer> tmp){
        if(tmp.size() == k ){
            result.add(new ArrayList<Integer>(tmp));
            return;
        }
        for(int i = start; i <= n; i++){
                tmp.addLast(i);
                helper(n, k,  i+1, result, tmp);
                tmp.removeLast();
            }
    }
}
