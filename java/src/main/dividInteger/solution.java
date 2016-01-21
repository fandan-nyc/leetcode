public class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor == 0)
            return Integer.MAX_VALUE;
        long dividendL = Math.abs((long) dividend);
        long divisorL = Math.abs((long) divisor);
        int counter = 1; 
        long result = 0 ;
        while(dividendL >= divisorL){
            while(dividendL >= (divisorL << counter)){
                counter++;
            }
            counter --; 
            result += ((long)1 << counter);
            dividendL -= (divisorL <<counter);
            counter = 1;
        }
        return getResult(dividend, divisor, result);
    }
    
    private int getResult(int dividend, int divisor, long result){
         if((dividend > 0 && divisor > 0) ||(dividend < 0 && divisor < 0)){
             if(result >= Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            return (int)result;
        }
        result = -1 * result;
        if( result <= Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
        return (int)result;       
    }
}
