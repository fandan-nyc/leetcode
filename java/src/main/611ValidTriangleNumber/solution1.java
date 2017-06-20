public class Solution {
    public int triangleNumber(int[] nums) {
        if(nums == null || nums.length <3){
            return 0;
        }
        Arrays.sort(nums);
        int total = 0;
        for(int i = nums.length-1; i >= 2; i--){
            int left = 0;
            int right = i-1;
            while(left < right){
                if(nums[left] + nums[right] > nums[i]){
                    total += right - left;
                    right --;
                }else{
                    left++;
                }
            }
        }
        return total ; 
    }
}
