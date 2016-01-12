
public class Solution {
    public boolean isPalindrome(int x) {
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
