public class Solution {
    public boolean isPalindrome(int x) {
        // we do not care about the overflow, since we are asking for the polindrome integer. 
        // if you overflow, the number would be diff, and we know that it is not palindrome
        if(x < 0)
            return false;
        else if ( x < 10)
            return true;
       int xCopy = x;
       int xTmp = 0;
       while(x > 0){
           xTmp = xTmp * 10 + x%10;
           x /=10;
       }
       return xTmp == xCopy;
    }
}
