c int divide(int dividend, int divisor) {
        if(divisor == 0)
            return Integer.MAX_VALUE;
        return getResult(dividend, divisor);
    }
    
    private long helper(long dividend, long divisor){
        // assume both are positive
        if(dividend < divisor){
            return 0;
        }
        int counter  = 0;
        while(dividend >= divisor << counter){
            counter++;
        }
        long tmp = ((long)1 << --counter);
        return tmp + helper(dividend - (divisor<< counter), divisor );
    }
    
    private int getResult(int dividend, int divisor){
        long dividendL = Math.abs((long) dividend);
        long divisorL = Math.abs((long) divisor);
        long result = helper(dividendL, divisorL);
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


