public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>(); 
        if(nums == null || nums.length == 0){
            return result;
        }
        boolean[] visited = new boolean[nums.length];
        helper(result, nums, new ArrayList<Integer>(), visited);
        return result;
    }
    
    private void helper(List<List<Integer>> result, int[] nums, List<Integer> tmp, boolean[]visited){
        if(tmp.size() == nums.length){
            result.add(new ArrayList<Integer>(tmp));
            return;
        }
        for(int i = 0; i < nums.length; i++){
         if( visited[i] || (i > 0 && nums[i] ==  nums[i-1] && !visited[i-1] )){
                continue;
            }
            visited[i] = true;
            tmp.add(nums[i]);
            helper(result, nums, tmp, visited);
            visited[i] = false;
            tmp.remove(tmp.size()-1);
        }
        
    }
}
