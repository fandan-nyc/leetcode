public class Solution {
    public int jump(int[] nums) {
        if(nums == null || nums.length <= 1){
            return 0;
        }
        int start = 0;
        int furthest  = 0;
        int end = 0;
        int count = 0;
        while(end < nums.length-1){
            count += 1;
            furthest = start;
            for(int j = start; j <= end ; j++){
                furthest = (furthest > j+nums[j])? furthest : (j + nums[j]);
            }
            start = end +1; 
            end = furthest;
        }
        return count;
    }
}
