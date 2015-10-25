public class Solution {
    public int majorityElement(int[] nums) {
        int result = nums[0];
        int count = 1 ; 
        for( int i : nums)
        {
            if(i == result)
            {
                count ++;
            }
            else
            {
                count--;
                if( count == 0)
                {
                    result = i;
                    count = 1;
                }
            }
        }
        return result ; 
    }
}
