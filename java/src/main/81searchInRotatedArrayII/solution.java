public class Solution {
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return false;
        }
        int start  = 0; 
        int end = nums.length-1;
        while(start <= end){
            int middle = start + (end - start) /2;
            int tmp = nums[middle];
            if(tmp == target){
                return true;
            }
            while(start < middle && tmp == nums[start]){
                ++ start;
            }
            while(middle < end && tmp == nums[end]){
                --end;
            }
            
            if(tmp >= nums[start]){
                if(target >= nums[start] && target < tmp){
                    end = middle-1;
                }else{
                    start = middle +1;
                }
            }else {
                // tmp < nums[start]
                if(target > tmp && target <= nums[end]){
                    start = middle +1;
                }
                else{
                    end = middle-1;
                }
            }
        }
        return false;
    }
}
