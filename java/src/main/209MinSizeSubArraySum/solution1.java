public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int min = nums.length+1;
        for(int i = 0; i < nums.length; i++){
            int sum = 0;
            for(int j = i; j < nums.length; j++){
                sum += nums[j];
                if(sum >= s){
                    min = Math.min(min, (j-i+1));
                    break;
                }
            }
        }
        return min == nums.length+1 ? 0: min;
    }
}
