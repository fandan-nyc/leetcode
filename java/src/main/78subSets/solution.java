public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>(); 
        if(nums == null || nums.length == 0){
            return result;
        }
        helper(result, nums, new ArrayList<Integer>(), 0);
        result.add(new ArrayList<Integer>());
        return result;
    }
    
    private void helper(List<List<Integer>> result, int[] nums, List<Integer> tmp, int start){
        for(int i = start; i < nums.length; i++){
            tmp.add(nums[i]);
            result.add(new ArrayList<Integer>(tmp));
            helper(result, nums, tmp, i+1);
            tmp.remove(tmp.size()-1);
        }
    }
}
