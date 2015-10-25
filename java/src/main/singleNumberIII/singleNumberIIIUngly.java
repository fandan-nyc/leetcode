public class Solution {
    public int[] singleNumber(int[] nums) {
        int tmp = 0;
        for(int i : nums)
        {
            tmp ^= i;
        }
        int count = 0 ;
        while( (tmp & 1) != 1)
        {
            count ++;
            tmp = tmp >> 1;
        }
        int first = 0;
        for(int i: nums)
        {
            int afterShift = i >> count;
            first ^= ( (tmp & afterShift) %2 == 0 ? i : 0);
        }
        tmp = tmp << count ; 
        return new int[]{first,first ^ tmp };
    }
}
