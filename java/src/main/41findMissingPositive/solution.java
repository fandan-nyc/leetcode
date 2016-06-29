public class Solution {
    public int firstMissingPositive(int[] nums) {
        for(int i=0 ;i < nums.length; i++){
            if(nums[i] <= 0 || nums[i] > nums.length){
                nums[i] = nums.length+1;
            }
        }
        for(int i = 0; i < nums.length; i++){
            int pos = nums[i] > 0 ? nums[i] : (-1 *nums[i] );
            if(pos <= nums.length && nums[pos-1] > 0){
                nums[pos-1] *= -1;
            }
        }
        for(int i = 0 ; i < nums.length; i++){
            if(nums[i] > 0 ){
                return i+1;
            }
        }
        return nums.length+1;
    }
}
