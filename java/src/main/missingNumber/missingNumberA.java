public class Solution {
    public int missingNumber(int[] nums) {
        int result = (int)(zeroToN(nums.length) - sum(nums));
        return result;
    }
    
    private long zeroToN(int n){
        return n * (n+1)/2;
    }
    
    private long sum(int[] nums){
        long result = 0; 
        for(int i: nums){
            result += i;
        }
        return result;
    }
}
