public class Solution {
    public int numDistinct(String s, String t) {
        if(s == null || t == null || s.length() == 0 || t.length() == 0){
            return 0;
        }
        int[][] dp = new int[s.length()+1][t.length()+1];
        for(int i = 0; i < s.length(); i ++){
            dp[i][0] = 1;
        }
        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j < t.length() && j <= i;j++){
                if(s.charAt(i) != t.charAt(j)){
                    dp[i+1][j+1] = dp[i][j+1];
                }else{
                    dp[i+1][j+1] = dp[i][j] + dp[i][j+1]; 
                }
            }
        }
        return dp[s.length()][t.length()];
    }
}
