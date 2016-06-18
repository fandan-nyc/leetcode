public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int[] sum = new int[nums.length+1];
        sum[0] = 0;
        for(int i = 0;i < nums.length;i++){
            sum[i+1] = nums[i] + sum[i];
        }
        if(sum[nums.length] < s){
            return 0;
        }
        int end = 1;
        while(sum[end] < s){
            end++;
        }
        int min = end;
        for(int i =  end; i < sum.length;i++){
            int start = binarySearch(sum, i, sum[i] - s);
            min = (i - start) < min ? (i-start): min;
        }
        return min;
    }
    
    private int binarySearch(int[] nums, int end, int target){
        int start = 0;
        while( start <= end){
            int middle = start + (end - start) /2 ; 
            if(nums[middle] == target)
                return middle;
            else if(nums[middle] < target)
                start = middle+1;
            else 
                end = middle-1;
        }
        return end;
    }
}
