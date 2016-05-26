public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = binSearch(nums, target, true);
        int end =   binSearch(nums, target, false);
        return new int[]{start,end};
    }
    
    private int binSearch(int[] nums, int target, boolean isLast){
        int start = 0; 
        int end = nums.length -1;
        int index = -1 ;
        while(start <= end){
            int middle = start + (end -start) /2;
            if(isLast){
                if(nums[middle] < target)
                    start = middle +1;
                else
                    end = middle -1;
            }else{
                if(nums[middle]<= target)
                    start = middle+1;
                else
                    end = middle -1;
            }
            if(nums[middle] == target){
                index = middle;
            }
        }
    return index;
    }
}
