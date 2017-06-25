public class Solution {
    private int[][] store ;
    public int findTargetSumWays(int[] nums, int S) {
        // brute force with memorization
        store =  new int[nums.length][2001];
        for(int i = 0; i < nums.length; i++)
            Arrays.fill(store[i], Integer.MIN_VALUE);
        return helper(nums, S, 0, 0);
    }
    
    private int helper(int[] nums, int target, int sum, int start){
        if(start == nums.length){
            return sum == target ? 1: 0;
        }else{
            if(store[start][sum+1000] != Integer.MIN_VALUE){
                return store[start][sum+1000];
            }else{
                int add = helper(nums, target , sum + nums[start], start+1);
                int minus = helper(nums, target , sum - nums[start], start+1);
                store[start][sum+1000] = add + minus;
                return add + minus;
            }
        }
    }
}
