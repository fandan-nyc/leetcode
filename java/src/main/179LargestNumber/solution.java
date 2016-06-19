public class Solution {
    public String largestNumber(int[] nums) {
        if(nums==null || nums.length == 0){
            return "";
        }
        boolean allZero = true;
        for(int i: nums){
            allZero = allZero && (i == 0);
            if(!allZero){
                break;
            }
        }
        if(allZero){
            return "0";
        }
        reverseQuickSort(nums, 0, nums.length-1);
        String result  = "";
        for(int i: nums){
            result += i;
        }
        return result;
    }
    
    private int compare(int a , int b){
        if(a == b){
            return 0;
        }else if( a == 0 || b == 0){
            return a - b;
        }
        char[] tmp1 = ((""+a)+b).toCharArray();
        char[] tmp2 = ((""+b)+a).toCharArray();
        for(int i = 0; i < tmp1.length ;i++){
            if(tmp1[i] != tmp2[i]){
                return tmp1[i] - tmp2[i];
            }
        }
        return 0 ;
    }
    
    private void reverseQuickSort(int[] nums, int start, int end){
        if(start >= end){
            return ; 
        }
        int pivot = nums[start];
        int left = start +1 ; 
        for(int i= start +1; i < nums.length;i++){
            if(compare(nums[i],pivot) > 0){
                swap(nums,i,left++);
            }
        }
        swap(nums, start, left-1);
        reverseQuickSort(nums, start, left-2);
        reverseQuickSort(nums, left, end);
    }
    
    private void swap(int[] x, int a, int b){
        int tmp = x[a];
        x[a] = x[b];
        x[b] = tmp;
    }
}
