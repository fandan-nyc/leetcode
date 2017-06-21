public class Solution {
    public int subarraySum(int[] nums, int k) {
        int counter = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = i; j < nums.length; j++){
                if(subSum(nums, i, j) == k){
                    counter++;
                }
            }
        }
        return counter;
    }
    
    private int subSum(int[] nums, int start, int end){
        int result = nums[start];
        while(start < end){
            result += nums[++start];
        }
        return result;
    }
}
