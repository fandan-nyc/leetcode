public class Solution {
    
    public boolean isInterleave(String s1, String s2, String s3) {
        // recursive
        if(s1 == null || s2 == null || s3 == null){
            return false;
        }
        if(s3.length() != s1.length() + s2.length()){
            return false;
        }
        if(s1.length() == 0){
            return s2.equals(s3);
        }
        if(s2.length() == 0){
            return s1.equals(s3);
        }
        final int s3Len = s3.length();
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        dp[0][0] = true;
        for(int i = 1; i <= s1.length();i++){
            dp[i][0] = dp[i-1][0] && s1.charAt(i-1) == s3.charAt(i-1);
        }
        for(int i = 1; i <= s2.length();i++){
            dp[0][i] = dp[0][i-1] && s2.charAt(i-1) == s3.charAt(i-1);
        }
        for(int i = 0; i < s1.length(); i++){
            for(int j = 0; j < s2.length(); j++){
                boolean result  = false; 
                dp[i+1][j+1]  = (dp[i][j+1] && s1.charAt(i) == s3.charAt(i+j+1)) ||  (dp[i+1][j] && s2.charAt(j) == s3.charAt(i+j+1)) ;
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
