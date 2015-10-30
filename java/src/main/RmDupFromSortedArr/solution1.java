public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums ==  null || nums.length == 0)
        {
            return 0;
        }
        int z= -1; 
        int tmp = nums[0]-1;
        for(int i = 0; i < nums.length ; i++)
        {
          if(nums[i] != tmp)
          {
              tmp = nums[i];
              nums[++z] = nums[i];
          }
        }
        return z+1 ;
    }
}
