public class Solution {
    public int missingNumber(int[] nums) {
        int largest  = nums.length ;
        int sum = (largest+1) * (largest) /2; 
        int tmp =0 ; 
        for(int i: nums)
        {
            tmp += i;
        }
        return sum - tmp ;
    }
}
