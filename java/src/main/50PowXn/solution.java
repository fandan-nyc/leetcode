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
        if(n == 0){
            return 1;
        }else if(n == 1 || n == -1){
            return x;
        }
        double tmp =  myPowHelper(x, n/2);
        return tmp * tmp * (n%2 == 0? 1: x);
    }
}
