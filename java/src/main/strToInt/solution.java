public class Solution {
    public int myAtoi(String str) {
        if(str == null)
            return 0;
        str = str.trim();
        if(str.length() == 0)
            return 0;
        long result  = 0; 
        int startPosition = 0 ;
        boolean positive = true;
        char first = str.charAt(0);
        if(!isSign(first) && !isNumeric(first))
            return (int)result;
        else if(first == '+'){
            startPosition = 1;
        }
        else if(first == '-' ){
            startPosition = 1;
            positive = false;
        }
        for( int i = startPosition;i < str.length(); i ++){
            char j = str.charAt(i);
            if(isNumeric(j))
                result = result * 10 + (positive ? ( j - '0' ): ('0' - j));
            else 
                return (int) result;
            if(result > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            else if ( result < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
        }
        return (int)result;
        
    }
    
    private boolean isNumeric( char i){
        return i >= '0' && i <= '9';
    }
    
    private boolean isSign(char i){
        return i == '+' || i == '-';
    }
}
