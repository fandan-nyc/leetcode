public class Solution {
    public int findDuplicate(int[] nums) {
        for(int i = 0; i < nums.length; i++)
        {
            int k = Math.abs(nums[i]);
            if(nums[k] < 0)
            {
                return k;
            }
            else 
            {
                nums[k] *= -1;
            }
        }
        return -1;
    }
}
