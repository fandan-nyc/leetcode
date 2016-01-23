public class Solution {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() <= 1)
            return true;
        int low = 0;
        int high = s.length() -1;
        s = s.toLowerCase();
        while(low <= high){
            while(high >= low && !isValid(s.charAt(high))){
                high--;
            }
             while( low <= high && !isValid(s.charAt(low))){
                low++;
            }
            if(high < low){
                return true;
            }
            if(Character.toLowerCase(s.charAt(high)) != Character.toLowerCase(s.charAt(low))){
                return false;
            }
            low++;
            high --;
        }
        return true;
    }
    
    private boolean isAlphabetical(char s){
        return (s >= 'a' && s <= 'z') || (s >= 'A' && s <='Z'); 
    }
    
    private boolean isNum(char s){
        return s >= '0' && s <= '9';
    }
    
    private boolean isValid(char s){
        return isAlphabetical(s) || isNum(s);
    }
}
