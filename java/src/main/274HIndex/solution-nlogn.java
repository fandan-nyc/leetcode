public class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0){
            return 0;
        }
        reverseQuickSort(citations,0, citations.length-1);
        int hIndex = 0;
        for(int i = 0; i < citations.length;i++){
            if(citations[i] >= i+1)
                hIndex = i+1;
        }
        return hIndex;
    }
    
    private void reverseQuickSort(int[] nums, int start, int end){
        if(start >= end){
            return ;
        }
        int pivot = nums[start];
        int left = start+1;
        for(int i  = start+1; i <= end; i++){
            if(nums[i] > pivot){
                swap(nums,i,left);
                left ++;
            }
        }
        swap(nums, start, left-1);
        reverseQuickSort(nums, start, left-2);
        reverseQuickSort(nums, left, end);
    }
    
    private void swap(int[] nums, int a, int b){
        int tmp =nums[a];
        nums[a] = nums[b];
        nums[b] = tmp ;
    }
}
