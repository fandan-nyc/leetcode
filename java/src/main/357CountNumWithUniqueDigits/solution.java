public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        // dp, n = 1, total is 10
        // n = 2, f(1) + two digits etc
        if(n == 0){
            return 1;
        }
        int result = 10;
        for( int i = 2; i <= n;i++){
            int start = 9;
            for(int j = 0; j < i-1;j++){
                start *= (9-j);
            }
            result += start;
        }
        return result;
    }
}
