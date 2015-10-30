public class Solution {
    public void moveZeroes(int[] nums) {
        int count = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] == 0)
            {
                count++;
            }
            else
            {
               nums[i-count] =  nums[i];
            }
        }
        int len = nums.length -1 ; 
        for(int i = count -1; i >=0;i--)
        {
            nums[len -i] = 0;
        }
    }
}
