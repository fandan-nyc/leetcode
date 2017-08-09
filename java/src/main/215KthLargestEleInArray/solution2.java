public class Solution {
    public int findKthLargest(int[] nums, int k) {
        mergeSort(nums, 0, nums.length-1);
        for(int i: nums){
            System.out.println(i);
        }
        return nums[nums.length -1 - k+1];
    }
    
    private void mergeSort(int[] nums, int start, int end){
        if(start >= end){
            return ;
        }
        int middle = start + (end - start) /2 ; 
        mergeSort(nums, start, middle);
        mergeSort(nums, middle+1, end);
        merge(nums, start, middle, end);
    }
    
    private void merge(int[] nums, int start, int middle, int end){
        int left = start; 
        int right = middle+1; 
        int[] tmp = new int[end-start+1];
        int counter = 0;
        while(left <= middle && right <= end){
            if(nums[left] < nums[right]){
                tmp[counter]= nums[left++];
            }else{
                tmp[counter] = nums[right++];
            }
            counter++;
        }
        while(left <= middle){
            tmp[counter++] = nums[left++];
        }
        while(right <= end){
            tmp[counter++] = nums[right++];
        }
        for(int i = 0; i < tmp.length; i++){
            nums[start + i] = tmp[i];
        }
    }
    
    private void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
