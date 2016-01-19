public class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int counter = 0;
        for(int i = 0 ; i < nums.length; i++){
            while(i < nums.length && nums[i] == val){
                i++;
            }
            if(i < nums.length){
                nums[counter] = nums[i];
                counter++;
            }
        }
        return counter;
    }
}
