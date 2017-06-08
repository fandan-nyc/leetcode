public class Solution {
    public int removeElement(int[] nums, int val) {
        int next = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                nums[next] = nums[i];
                next++;
            }
        }
        return next;
    }
}
