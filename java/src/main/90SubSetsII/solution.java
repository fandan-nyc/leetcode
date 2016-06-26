public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0){
            return result;
        }
        Arrays.sort(nums);
        result.add( new ArrayList<Integer>());
        boolean[] visited = new boolean[nums.length];
        helper(result, new ArrayList<Integer>(), nums, 0, visited);
        return result;
    }
    
    private void helper(List<List<Integer>> result, List<Integer> tmp, int[] nums, int start, boolean[] visited){
        for(int i = start; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i-1] && !visited[i-1]){
                continue;
            }
            visited[i] = true;
            tmp.add(nums[i]);
            result.add(new ArrayList<Integer>(tmp));
            helper(result, tmp, nums, i+1, visited);
            visited[i] =  false;
            tmp.remove(tmp.size()-1);
        }
    }
}
