public class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        return helper(nums, 0, nums.length-1, target);
    }
    
    private int helper(int[] nums, int start, int end, int target){
        if(start > end){
            return -1;
        }
        while(start <= end){
          int middle = start + (end - start)/2;
          int real = nums[middle];
          if(real == target){
              return middle;
           }
        
            if(nums[start] <= real){
                if(target >= nums[start] && target < real){
                    end = middle-1;
               }else{
                  start = middle+1;
                }
            }else{
                 if(target > real && target <=  nums[end]){
                      start =middle + 1;
                  }else{
                      end = middle-1;
                 }
            }
        }
        return -1;
    }
}
