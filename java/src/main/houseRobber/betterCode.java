public class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int robPrev = 0; 
        int notRobPrev = 0; 
        int tmp;
        for( int i: nums){
            tmp = Math.max(notRobPrev + i, robPrev);
            notRobPrev = robPrev;
            robPrev = tmp;
        }
        return Math.max(robPrev, notRobPrev);
    }
}
