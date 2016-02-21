public class Solution {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length <= 1){
            return ; 
        }
        k = k % nums.length;
        int counter = 0;
        int currValue = nums[0];
        int currPos = 0;
        int startPos = 0;
        while(counter++ < nums.length){
            int nextPos = (currPos + k) % nums.length; 
            int tmp = nums[nextPos];
            nums[nextPos] = currValue;
            currValue = tmp; 
            currPos = nextPos;
            if(currPos == startPos){
                currPos ++; 
                startPos ++; 
                currValue = nums[currPos%nums.length];
            }
        }
    }
}
