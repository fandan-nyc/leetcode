public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int counter = 1;
        int ptr = -1;
        int curr = nums[0] -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != curr){
                curr = nums[i];
                counter = 1;
                swap(nums, i, ++ptr);
            } else if(nums[i] == curr && counter < 2){
                ++counter;
                swap(nums, i, ++ptr);
            }else{
                while(i < nums.length && nums[i] == curr){
                    ++i;
                }
                --i;
            }
        }
        return ptr+1;
    }
    
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
