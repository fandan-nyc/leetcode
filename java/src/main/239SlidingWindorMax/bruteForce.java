public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length -k+1];
        if(nums == null || k == 0 || nums.length == 0){
            return new int[0];
        }
        for(int i = 0; i <= nums.length-k; i ++){
            int max = nums[i]-1;
            for(int j = 0; j< k;j++){
                max = max > nums[i+j]? max: nums[i+j];
            }
            result[i] = max;
        }
        return result;
    }
}
