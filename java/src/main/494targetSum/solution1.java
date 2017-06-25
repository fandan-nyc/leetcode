public class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        // brute force
        return helper(nums, S, 0, 0);
    }
    
    private int helper(int[] nums, int target, int sum, int start){
        if(start == nums.length){
            return target == sum ? 1: 0;
        }
        int add = helper(nums, target, sum + nums[start], start+1);
        int minus = helper(nums, target, sum - nums[start], start+1);
        return add+minus;
    }
}
