public class Solution {
    public int myAtoi(String str) {
        int result = 0; 
        int[][] states = new int[][]{{0,1,2,-1},
                                     {-1,-1,2,-1},
                                     {-1,-1,2,-1}
                         };
        int state = 0;
        boolean negative = false;
        for(int i= 0; i < str.length(); i++ ){
            int code = charToCode(str.charAt(i));
            state = states[state][code];
            if(state == -1){
                break;
            }else if(state == 1){
                negative = (str.charAt(i) == '-');
            }else if(state == 2){
                long tmp = ((long)result * 10) + str.charAt(i) - '0';
                if(negative  && ((-1 * tmp) <= (long)Integer.MIN_VALUE)){
                    return Integer.MIN_VALUE;
                }else if(  (!negative) && tmp >= Integer.MAX_VALUE){
                    return Integer.MAX_VALUE;
                }
                result = result * 10 +  str.charAt(i) - '0' ; 
            }
        }
        return (negative ? -1 : 1)*result;
    }
    
    int charToCode(char x){
        if( x == ' '){
            return 0;
        }else if( x == '+' || x == '-'){
            return 1;
        }else if( x >= '0' && x <= '9'){
            return 2;
        }
        return 3;
    }
}
