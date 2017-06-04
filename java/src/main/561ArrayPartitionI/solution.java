public class Solution {
    public int arrayPairSum(int[] nums) {
        quickSort(nums, 0, nums.length -1);
        int result = 0;
        for(int i = 0; i < nums.length; i++){
            if(i%2 == 0){
                result += nums[i];
            }
        }
        return result;
    }
    
   private void quickSort(int[] data, int start, int end){
       if(start >= end){
           return;
       }
       int low = start+1;
       int high = end;
       int pivot = data[start];
       while(low <= high){
           if(data[low] > pivot){
               swap(data, low, high);
               high--;
           }else{
               low++;
           }
       }
       swap(data, start, high);
       quickSort(data, start, high-1);
       quickSort(data, high+1, end);
   }
    
    private void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
