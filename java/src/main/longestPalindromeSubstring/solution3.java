// time: O(n^2) space O(1)
public class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() <= 2)
            return s;
        String result = "";
        for(int i = 0; i < s.length(); i++){
            String tmp = helper(s,i,i);
            if(tmp.length() > result.length())
                result = tmp;
            tmp = helper(s, i, i+1);
            if(tmp.length() > result.length())
                result = tmp;
            }
        return result;

}
    
    String helper(String s, int begin, int end){
        while(begin>=0 && end < s.length() && s.charAt(begin) == s.charAt(end))
        {
            begin--;
            end++;
        }
        return s.substring(begin+1, end);
    }
}
