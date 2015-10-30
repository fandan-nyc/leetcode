class Solution {
    public void moveZeroes(int[] nums) {
       int z = -1;
       for(int i = 0; i < nums.length ; i ++)
       {
           int tmp = nums[i];
           if(tmp != 0)
           {
               nums[i] = nums[++z];
               nums[z] = tmp;
           }
       }
       
    }
}

