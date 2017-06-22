public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int min = nums.length+1;
        int sum = 0;
        int start = 0;
        int end = 0;
        while(end < nums.length){
            sum += nums[end];
            while(sum >= s){
                min = Math.min(min, end-start +1);
                sum -= nums[start++];
            }
            end++;
        }
        return min == nums.length+1 ? 0: min;
    }
}
