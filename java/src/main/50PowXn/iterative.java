public class Solution {
    // iterative
    public double myPow(double x, int n) {
        double result = myPowHelper(x, n);
        if(n < 0){
            return 1/result;
        }
        return result;
    }
    
    private double myPowHelper(double x, int n) {
        double res = 1;
        while(n != 0){
            if(n %2 != 0){
                res *= x;
            }
            x *= x;
            n /= 2;
        }
        return res;
    }
}
