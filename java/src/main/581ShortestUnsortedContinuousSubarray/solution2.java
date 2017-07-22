public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < nums[i-1]){
                min = Math.min(min, nums[i]);
            }
        }
        for(int i = nums.length-2; i >=0; i--){
            if(nums[i] > nums[i+1]){
                max = Math.max(nums[i], max);
            }
        }
        if(min == Integer.MAX_VALUE){
            return 0;
        }
        int left = -1;
        int right = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > min){
                left = i;
                break;
            }
        }
        for(int i = nums.length-1; i >=0; i--){
            if(nums[i] < max){
                right = i;
                break;
            }
        }
        return right-left +1;
    }
}
