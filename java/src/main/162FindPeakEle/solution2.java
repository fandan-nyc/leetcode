public class Solution {
    public int findPeakElement(int[] nums) {
        if(nums == null ||nums.length <= 1){
            return 0;
        }
        int start = 1;
        int end = nums.length-2;
        while(start <= end){
            int middle = start + (end-start)/2;
            if(nums[middle] > nums[middle-1] && nums[middle] > nums[middle+1]){
                return middle;
            }else if(nums[middle] < nums[middle-1]){
                end = middle-1;
            }else{
                start = middle+1;
            }
        }
        return nums[0] > nums[1] ? 0: nums.length-1;
    }
}

/// 
public class Solution {
    public int findPeakElement(int[] nums) {
        int left  = 0; 
        int right = nums.length -1; 
        while(left < right){
            int middle = left + (right - left) /2; 
            if(nums[middle] < nums[middle+1]){
                left = middle+1;
            }else{
                right = middle;
            }
        }
        return left;
    }
}
