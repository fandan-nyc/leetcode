public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        boolean[] visited = new boolean[nums.length];
        backtracking(result, new ArrayList<Integer>(), nums, visited);
        return result;
    }
    
    private void backtracking(List<List<Integer>> result, List<Integer> curr, int[] nums, boolean[] visited){
        if(curr.size() == nums.length){
            result.add( new ArrayList<Integer>(curr));
        }
        for(int i = 0 ; i < nums.length;i++){
            if(!visited[i]){
                curr.add(nums[i]);
                visited[i] = true;
                backtracking(result, curr, nums, visited);
                curr.remove(curr.size()-1);
                visited[i] = false;
            }
        }
    }
}
