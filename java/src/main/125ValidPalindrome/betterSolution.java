public class Solution {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() <= 1)
            return true;
        s = s.replaceAll("\\W","").toLowerCase();
        int low = 0;
        int high = s.length()-1;
        while(low <= high){
            if(s.charAt(low++) != s.charAt(high--)){
                return false;
            }
        }
        return true;
    }
}
