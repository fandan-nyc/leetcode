public class Solution {
    public int searchInsert(int[] nums, int target) {
        return helper(nums, 0, nums.length-1, target);
    }
    
    public int helper(int[] nums, int start, int end, int target){
        int middle = (start + end )/2; 
        if(nums[middle] == target){
            return middle;
        }
        else if ( target < nums[middle] && (middle == 0 || target > nums[middle-1])){
            return middle;
        }
        else if ( target > nums[middle] && (middle == nums.length-1 || target < nums[middle+1])){
            return middle +1;
        }
        if(target < nums[middle]){
            return helper(nums, start, middle-1,target);
        }
        else{
            return helper(nums, middle+1, end,target);
        }
    }
}
