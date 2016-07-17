public class Solution {
    public int myAtoi(String str) {
        str = str.trim();
        long result = 0;
        boolean neg = false;
        for (int i = 0; i < str.length(); i ++ ) {
            if (i == 0 && (str.charAt(i) == '-' || str.charAt(i) == '+')) {
                neg = str.charAt(i) == '-' ? true : false;
                continue;
            }
            if (str.charAt(i) < '0' || str.charAt(i) > '9') break;
            result = neg ? result * 10 - ( str.charAt(i) - '0' ) : result * 10 + ( str.charAt(i) - '0' );
            if (result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }
        return (int)result;
    }
}
