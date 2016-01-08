// O(n^3)
public class Solution {
    public String longestPalindrome(String s) {
        String result = null;
        int max = 1;
        for(int i = 0; i < s.length(); i ++){
                for(int j = i+max; j < s.length(); j++){
                        String tmp = s.substring(i,j+1);
                        if(isPalindrome(tmp) && j-i > max) 
                        {
                            result = tmp;
                            max= tmp.length();
                        }
                }
        }
        return result;
    }
    
    boolean isPalindrome(String s)
    {
        for(int i = 0; i < s.length() /2; i++){
            if(s.charAt(i) != s.charAt(s.length() - i -1))
                return false;
        }
        return true;
    }
}
