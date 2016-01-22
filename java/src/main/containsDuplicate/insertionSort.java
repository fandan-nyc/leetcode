// hashset 
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        if(nums == null || nums.length <= 1){
            return false;
        }
       int curr; 
       for(int i = 1; i < nums.length; i ++){
            curr = i;
            while(curr >= 1 && nums[curr] < nums[curr-1]){
                switchItem(nums, curr, curr-1);
                curr --;
            }
            if(curr >= 1 && nums[curr] == nums[curr-1]){
                return true;
            }
       }
       return false;
    }
    
    private void switchItem(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
