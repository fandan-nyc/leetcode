public class Solution {
    public int majorityElement(int[] nums) {
        if(nums == null || nums.length == 0)
            return -1;
        int counter = 0;
        int curr =  nums[0];
        for(int i: nums){
            if(counter == 0){
                curr = i;
                counter ++;
            }else if(i != curr){
                counter --;
            }else{
                counter ++;
            }
        }
        return curr;
    }
}
