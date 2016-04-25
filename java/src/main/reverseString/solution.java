public class Solution {
    public String reverseString(String s) {
        if( s == null || s.length() <= 1){
            return s;
        }
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        for(int i = len -1; i >= 0;i --){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
