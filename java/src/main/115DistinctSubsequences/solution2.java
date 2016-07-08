public class Solution {
    public int numDistinct(String s, String t) {
        if(s == null || t == null || s.length() == 0 || t.length() == 0){
            return 0;
        }
        // if s[i] != t[j] ==> dp[i][j] = dp[i-1][j]
        // if s[i] == t[j] ==> dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
        // so we know that dp[i] only depends on dp[i-1]
        // we can shrink the memory usage from m*n to m
        int[]dp = new int[t.length()];

        for(int i = 0; i < s.length(); i++){
            for(int j = t.length() -1; j >= 0 ;j--){
                if(s.charAt(i) == t.charAt(j)){
                    if(j == 0){
                        dp[j] = dp[j] + 1;
                    }else{
                        dp[j] = dp[j] + dp[j-1];
                    }
                }
            }
        }
        return dp[t.length()-1];
    }
}
