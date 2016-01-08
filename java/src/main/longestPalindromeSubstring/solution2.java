// DP, space O(n^2) space O(n^2)
public class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() <= 2)
            return s;
        int sLen = s.length();
        boolean map[][] = new boolean[sLen][sLen];
        for(int i = 0; i < sLen;i++)
            map[i][i] = true;
        int max = 0;
        String result = "";
        for(int i=0; i < sLen -1; i++)
            if(s.charAt(i) == s.charAt(i+1)){
                map[i][i+1] = true;
                if(max < 2){
                    max = 2;
                    result = s.substring(i,i+2);
                }
            }
      
        for(int i= 3; i<=sLen;i++)
            for(int j=0;j <= sLen -i; j++){
                if(s.charAt(j) == s.charAt(j+i-1))
                    map[j][j+i-1] = map[j+1][j+i-2];
                if(map[j][j+i-1] && i > max){
                    max = i;
                    result = s.substring(j,j+i);
                }
            }
        return result;
    }
}
