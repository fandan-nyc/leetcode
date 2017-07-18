public class Solution {
    public boolean find132pattern(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int j = 0; j < nums.length -1; j++){
            min = Math.min(nums[j], min);
            for(int k = j+1; k < nums.length;k++){
                if(nums[k] < nums[j] && nums[k] > min){
                    return true;
                }
            }
        }
        return false;
    }
}
