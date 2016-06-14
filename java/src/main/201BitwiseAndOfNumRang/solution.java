public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        // all the bits that m & n are different will end up in 0 
        int count = 0;
        while(m != n ){
            m = m >> 1;
            n = n >> 1;
            count++;
        }
        return m << count;
    }
}
