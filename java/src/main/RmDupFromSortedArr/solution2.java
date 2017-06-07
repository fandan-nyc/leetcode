public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null){
            return 0;
        }else if(nums.length < 2){
            return nums.length;
        }
        int next  = 1; 
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i-1]){
                nums[next] = nums[i];
                next++;
            }
        }
        return next;
    }
}
