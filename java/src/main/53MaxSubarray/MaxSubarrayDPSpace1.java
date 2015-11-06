public class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0)
        {
            return 0;
        }
        int tmpMax = nums[0];
        int max = nums[0];
         for(int i = 1; i < nums.length; i++)
        {
            tmpMax = Math.max(tmpMax+ nums[i], nums[i]);
            max =  Math.max(tmpMax, max);
        }
        return max ;
    }
}
