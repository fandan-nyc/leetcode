public class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int first = nums[0];
        int second = Math.max(nums[0],nums[1]);
        int max = second;
        int tmp;
        for(int i = 2; i < nums.length; i ++){
            max =  Math.max(first + nums[i], second);
            tmp = second; 
            second = max;
            first = tmp;
        }
        return max;
    }
}
