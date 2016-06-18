public class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums == null || nums.length < 3 )
            return false;
        boolean[] isMax = new boolean[nums.length];
        boolean[] isMin = new boolean[nums.length];
        int min = nums[0];
        int max = nums[nums.length-1];
        for(int i = 0; i < nums.length;i++){
            isMax[i] = nums[i] > min;
            min = min <nums[i] ? min: nums[i];
        }
        for(int j = nums.length-1; j >= 0 ;j--){
            isMin[j] = nums[j] < max;
            max = max > nums[j] ? max: nums[j];
        }
        for(int i = 0; i < nums.length;i++){
            if(isMax[i] && isMin[i])
                return true;
        }
        return false;
    }
}
