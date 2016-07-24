public class Solution {
    public double myPow(double x, int n) {
        if(n == 0){
            return 1;
        }
        // recursive
        boolean positive = n > 0;
        return positive ? helper(x, (long) n) : 1/ helper(x, (long)n * -1);
    }
    
    private double helper(double x, long n){
        Stack<Double> stack = new Stack<Double>();
        stack.push(x);
        long count  = 1;
        while( count <= n){
            stack.push(stack.peek() * stack.peek());
            count = count << 1;
        }
        double result = 1;
        while(n != 0){
            double tmp = stack.pop();
            if(count <= n){
                result *= tmp;
                n -= count;
            }
            count = count >>> 1;
        }
        return result;
    }
}
