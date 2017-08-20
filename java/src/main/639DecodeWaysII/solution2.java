class Solution {
    private static int M = 1000000007;
    public int numDecodings(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        long[] dp = new long[s.length()+1];
        dp[0] = 1L;
        dp[1] = s.charAt(0) ==  '*' ? 9: s.charAt(0) == '0'? 0 : 1;
        for(int i = 1; i < s.length(); i++){
            char curr = s.charAt(i);
            if(curr == '*'){
                dp[i+1] = dp[i] * 9 %M;
                if(s.charAt(i-1) == '1'){
                    dp[i+1] = (dp[i+1] + dp[i-1] * 9) % M;
                }else if(s.charAt(i-1) =='2'){
                    dp[i+1] = (dp[i+1] + dp[i-1] * 6) % M;
                }else if(s.charAt(i-1) == '*'){
                    dp[i+1] = (dp[i+1] + dp[i-1] * 15) % M;
                }
            }else{
                dp[i+1] = curr == '0' ? 0 : dp[i];
                if (s.charAt(i - 1) == '1')
                    dp[i + 1] = (dp[i + 1] + dp[i - 1])%M;
                else if (s.charAt(i - 1) == '2' && s.charAt(i) <= '6')
                    dp[i + 1] = (dp[i + 1] + dp[i - 1]) %M ;
                else if (s.charAt(i - 1) == '*')
                    dp[i + 1] = (dp[i + 1] + (s.charAt(i) <= '6' ? 2 : 1) * dp[i - 1])%M;
            }
        }
        return (int)dp[s.length()];
    }
}
