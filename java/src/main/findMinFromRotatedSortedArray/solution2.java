public class Solution {
    public int findMin(int[] nums) {
        int start  = 0; 
        int end = nums.length-1;
        while(start < end){
            int middle = (start + end) /2 ; 
            if( middle >= 1 && nums[middle] < nums[middle-1]){
                return nums[middle];
            }
            else if( nums[middle] >= nums[start] && nums[middle] >= nums[end]){
                start = middle +1 ; 
            }
            else{
                end = middle -1;
            }
        }
        return nums[start];
    }
}
