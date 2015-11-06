public class Solution {
    public boolean isPalindrome(String s) {
        int start = 0; 
        int end = s.length() -1; 
        while( start < end)
        {
            if(!isValid(s.charAt(start)))
            {
                start ++;
            }
            else if ( ! isValid(s.charAt(end)))
            {
                end --;
            }
            else
            {
                if(checkVal(s.charAt(start)) != checkVal(s.charAt(end)))
                {
                    return false ;
                }
                start ++;
                end --;
            }
        }
        return true;
    }
    
    private boolean isCapital( char i)
    {
        return i >= 'A' && i <= 'Z';
    }
    private boolean isLowerCase(char i)
    {
        return i >= 'a' && i <= 'z';
    }
    
    private boolean isNumber(char i)
    {
        return i >= '0' && i <= '9';
    }
    
    private boolean isValid(char i)
    {
        return isCapital(i) || isLowerCase(i) || isNumber(i);
    }
    
    private int checkVal(char i)
    {
        if(isNumber(i))
        {
            return i;
        }
        return isCapital(i) ? (i - 'A') : (i -'a');
    }   
}
