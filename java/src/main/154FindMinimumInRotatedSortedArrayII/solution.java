public class Solution {
    public int findMin(int[] nums) {
        int start  = 0; 
        int end = nums.length-1;
        while(start  < end){
            while(start < end && nums[start] == nums[end]){
                start++;
            }
            int middle = (start + end) /2 ; 
            if( nums[middle] > nums[end]){
                start = middle +1 ; 
            }
            else{
                end = middle;
            }
        }
        return nums[start];
    }
}
