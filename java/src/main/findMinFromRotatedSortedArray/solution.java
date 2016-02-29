public class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0){
            throw new IllegalArgumentException("haha, nums is not valid");
        }
        if(nums.length == 1){
            return nums[0];
        }
        int start  = 0; 
        int end = nums.length-1;
        return findMinHelper(nums, start, end);
    }
    
    private int findMinHelper(int[] nums, int start, int end){
        if(nums[start] <= nums[end]){
            return nums[start];
        }
        int middle = ( start + end)/2;
        return Math.min(findMinHelper(nums,start, middle), findMinHelper(nums, middle+1, end));
    }
}
