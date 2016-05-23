public class Solution {
    public double myPow(double x, int n) {
        if(n == 0){
            return 1;
        }
        long longN = (long)n;
        boolean positive = longN > 0;
        longN = positive? longN: -1 * longN;
        double result = powHelper(x, longN);
        return positive? result: (1/result);
    }
    
    private double powHelper(double x, long n){
        if(n == 1){
            return x;
        }else {
            double t = powHelper(x, n/2) ;
            return n%2 ==0 ? t*t : t*t*x;
        }
    }
}
