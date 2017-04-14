public class Solution {
    public int[] singleNumber(int[] nums) {
        int tmp = 0;
        for(int i : nums)
        {
            tmp ^= i;
        }
        int lastBit =  tmp & (tmp -1) ^ tmp; // find the last none-zero bit
        int first  = 0;
        int second = 0;
        for(int i: nums)
        {
            if((lastBit & i) == 0)
            {
                first ^= i;
            } 
            else
            {
                second ^= i;
            }
        }
        return new int[]{first,second };
    }
}
