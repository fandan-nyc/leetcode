//10. Regular Expression Matching My Submissions Question
public class Solution {
    public boolean isMatch(String s, String p) {
        if(s == null && p == null)
            return true;
        else if( s== null || p == null)
            return false;
        int sLen = s.length();
        int pLen = p.length();
        boolean[][] map = new boolean[sLen+1][pLen+1];
        map[0][0] = true;
        for(int i=0; i <=sLen; i++)
            for(int j=1;j<=pLen;j++){
                char tmp = p.charAt(j-1);
                if(tmp != '*'){
                    map[i][j] = (i>= 1) && (s.charAt(i-1) == tmp || tmp == '.') && map[i-1][j-1];
                }
                else{
                    map[i][j] = (j >= 2 && map[i][j-2]) || (i>= 1 && map[i-1][j]  &&  (s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.' ));
                }
            }
        return map[sLen][pLen];

    }
}
