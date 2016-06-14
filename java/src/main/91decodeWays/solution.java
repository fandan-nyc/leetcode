public class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0 ){
            return 0;
        }
        int[] dp = new int[s.length()];
        dp[0] = s.charAt(0) == '0' ? 0: 1;
        for(int i = 1; i < s.length();i++){
            if(s.charAt(i) == '0'){
                dp[i] = 0;
            }else{
                dp[i] += dp[i-1];
            }
            if(s.charAt(i-1) == '1' || (s.charAt(i-1) == '2' && s.charAt(i) <= '6')){
                dp[i] += (i >= 2? dp[i-2]:1);
            }
        }
        return dp[s.length()-1];
    }
}
