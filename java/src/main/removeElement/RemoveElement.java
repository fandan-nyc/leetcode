public class Solution {
    public int removeElement(int[] nums, int val) {
        int x = -1;
        for(int i= 0; i < nums.length; i++)
        {
            if(nums[i] != val)
            {
                nums[++x] = nums[i];
            }
        }
        return x+1 ;
    }
}
