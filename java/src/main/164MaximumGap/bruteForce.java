public class Solution {
    public int maximumGap(int[] nums) {
        if(nums == null || nums.length < 2){
            return 0;
        }
        // brute force 
       // sort first, the calc the max 
       // complexity: nLog(n)
       quickSort(nums, 0, nums.length-1);
       int max = -100;
       for(int i = 1; i < nums.length; i++){
            int tmp = nums[i] - nums[i-1];
            max = (max > tmp) ? max: tmp;
       }
       return max;
    }
    
    private void quickSort(int[] nums, int start, int end){
        // known that nums would be valid 
        if(start >= end){
            return ;
        }
        int pivot = nums[start];
        int curr = start+1;
        for(int i = start+1; i <= end; i++){
            if(nums[i] < pivot){
                swap(nums, i, curr++);
            }
        }
        swap(nums, start, curr-1);
        quickSort(nums, start, curr-2);
        quickSort(nums, curr, end);
    }
    private void swap(int[] nums, int a, int b){
        int tmp  = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
