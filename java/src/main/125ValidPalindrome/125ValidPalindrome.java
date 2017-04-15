public class Solution {
    public boolean isPalindrome(String s) {
        if(s == null){
            return false;
        }
        s = s.toLowerCase();
        int i = 0;
        int j = s.length()-1;
        while(i < j){
            while( i < j && isValid(s.charAt(i)) == false){
                i++;
            }
            while(i < j && isValid(s.charAt(j)) == false){
                j--;
            }
            if(i < j && s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;   
    }
    
    private boolean isValid(char x){
        return   (x >= 'a' && x <='z') || (x >= 'A' && x <= 'Z') || (x >= '0' && x <= '9');
    }
}
