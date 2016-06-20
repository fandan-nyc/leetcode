public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(candidates == null || candidates.length == 0){
            return result;
        }
        helper(result, new ArrayList<Integer>(), candidates, 0 , target);
        return result ;
    }
    
    private void helper(List<List<Integer>> result, List<Integer> tmp, int[] candidates, int start,  int target){
        if(target == 0 && tmp.size() > 0){
            result.add(new ArrayList<Integer>(tmp));
            return;
        }
        for(int i = start; i < candidates.length; i++ ){
            if(candidates[i] <= target){
                tmp.add(candidates[i]);
                helper(result, tmp, candidates, i,target-candidates[i]);
                tmp.remove(tmp.size()-1);
            }
        }
    }
}
