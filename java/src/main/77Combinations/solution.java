public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        backtracking(result, new ArrayList<Integer>(), n,k, 1);
        return result;
    }
    
    private void backtracking(List<List<Integer>> result, List<Integer> tmp, int n, int k,  int start){
        if(k == 0){
            result.add(new ArrayList<Integer>(tmp));
            return;
        }
        for(int i = start; i <= n; i++){
            tmp.add(i);
            backtracking(result, tmp, n,k-1, i+1);
            tmp.remove(tmp.size()-1);
        }
    }
}
