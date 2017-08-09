public class Solution {
    public int findKthLargest(int[] nums, int k) {
        // quick selection
        int pos = k;
        int start = 0;
        int end = nums.length-1;
        while(start <= end){
            pos = partition(nums, start, end);
            if(pos == k-1){
                break;
            }else if(pos > k-1){
                end = pos-1;
            }else{
                start = pos+1;
            }
        }
        return nums[pos];
    }
    
    private int partition(int[] nums, int start, int end){
        int pivot = nums[end];
        int left = start; 
        int next = start - 1;
        while(start < end){
            if(nums[start] > pivot){
                swap(nums, start, ++next);
            }
            start++;
        }
        swap(nums, end, ++next);
        return next;
    }
    
    private void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
