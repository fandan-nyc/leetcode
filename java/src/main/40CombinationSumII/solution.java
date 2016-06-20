public class Solution {
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        if(candidates == null || candidates.length == 0){
            return result;
        }
        helper(result, new ArrayList<Integer>(), candidates, target, 0);
        return result;
    }
    
    private void helper( List<List<Integer>> result, List<Integer> tmp, int[] candidates, int target, int start){
        if(target == 0 && tmp.size() > 0){
            result.add(new ArrayList<Integer>(tmp));
            return;
        }
        for(int i = start; i < candidates.length; i ++){
            if(i > start && candidates[i] == candidates[i-1]){
                continue;
            }
            if(candidates[i] <= target){
                tmp.add(candidates[i]);
                helper(result, tmp, candidates, target -candidates[i], i+1);
                tmp.remove(tmp.size() -1);
            }
        }
    }
    
}
