public class Solution {
    public int countDigitOne(int n) {
        if(n <= 0){
            return 0;
        }else if(n < 10){
            return 1;
        }
        int power = (int)Math.log10(n);
        int powerOfTen = (int)Math.pow(10, power);
        int divide = n / powerOfTen;
        if(divide == 1){
            return n%powerOfTen +1  + countDigitOne(n%powerOfTen) + divide * countDigitOne(powerOfTen-1);
        }else{
            return divide * countDigitOne(powerOfTen-1) + powerOfTen + countDigitOne(n%powerOfTen);
        }
        //https://discuss.leetcode.com/topic/18164/5-lines-solution-using-recursion-with-explanation/2
    }
}
