public class Solution {
    public int missingNumber(int[] nums) {
        int tmp =0 ; 
        for(int i = 0; i < nums.length; i++)
        {
            tmp += (i - nums[i] +1);
        }
        return tmp;
    }
}
