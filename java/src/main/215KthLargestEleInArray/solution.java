public class Solution {
    public int findKthLargest(int[] nums, int k) {
        quickSelect(nums, 0, nums.length -1, k);
        return nums[k-1];
    }
    
    public void quickSelect(int[] nums, int start, int end, int k){
        int pivot = nums[start];
        int next = start+1;
        for(int i = start+1; i <= end; i ++){
          if(nums[i] > pivot){
             swap(nums, i, next);
             ++next;
          }
        }
        swap(nums, start, next -1);
        if(next == k){
          return;
        }
        else if(next > k){
          quickSelect(nums, start, next-2, k);
        }
        else{
          quickSelect(nums, next, end, k);
        }
    }

    private void swap(int[] nums, int start, int end){
      int tmp = nums[start];
      nums[start] = nums[end];
      nums[end] = tmp;
    }

}
