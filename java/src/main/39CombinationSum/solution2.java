public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        backtracking(result, new ArrayList<Integer>(), candidates, target, 0);
        return result;
    }
    
    private void backtracking(List<List<Integer>> result, List<Integer> curr, int[] candidates, int target, int i){
        if( target == 0){
            result.add(new ArrayList<Integer>(curr));
            return ;
        }
        else if( i == candidates.length){
            return ;
        }
        
        for(int num = 0; target - num * candidates[i] >= 0; num++){
            int k = num; 
            while(k > 0){
                curr.add(candidates[i]);
                k--;
            }
            backtracking(result, curr, candidates,  target - num * candidates[i], i+1);
            k = num; 
            while(k > 0){
                curr.remove(curr.size()-1);
                k--;
            }
        }
    }
}
