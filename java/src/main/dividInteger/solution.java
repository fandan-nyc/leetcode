public class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)){
            return Integer.MAX_VALUE;
        }
        boolean negative = (dividend < 0) ^ (divisor < 0);
        long dividendLong = (dividend > 0 ? 1: -1) * (long) dividend;
        long divisorLong  = (divisor > 0 ?  1: -1) * (long) divisor;
        int counter = 0; 
        while(dividendLong >= divisorLong){
            int tmp = 0;
            while(dividendLong >= (divisorLong << tmp)){
                tmp ++;
            }
            dividendLong -= (divisorLong << (tmp -1));
            counter += (1 << (tmp-1));
        }
        return (negative ? -1: 1) * counter;
    }
}
