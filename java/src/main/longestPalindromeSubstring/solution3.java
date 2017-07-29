public class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() <= 1){
            return s;
        }
        int max  = 1 ;
        String res = s.substring(0,1);
        for(int i = 0; i < s.length(); i++){
            int oddLen  = palinHelper(s, i-1, i+1, 1);
            int evenLen = palinHelper(s, i, i+1, 0);
            int currMax = Math.max(oddLen, evenLen);
            if(currMax > max){
                max = currMax;
                res = s.substring(i-currMax/2 + (currMax%2 == 0 ? 1:0), i+currMax/2+1);
            }
        }
        return res;
    }
    
    private int palinHelper(String s, int start, int end, int currLen){
        while(start >= 0 && end <= s.length()-1 && s.charAt(start) == s.charAt(end)){
            currLen += 2;   
            start--;
            end++;
        }
        return currLen;
    }
}

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
