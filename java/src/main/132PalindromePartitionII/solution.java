public class Solution {
    public int minCut(String s) {
    
    boolean[][] isPalindrome = new boolean[s.length()][s.length()];
    int[] cuts  = new int[s.length()];
    for(int i = 0; i < s.length(); i++){
        int  min = Integer.MAX_VALUE;
        for(int j = 0; j <= i; j++){
            if(s.charAt(j)== s.charAt(i) && (j+1 > i-1 || isPalindrome[j+1][i-1])){
                isPalindrome[j][i] = true;
                min = j == 0 ? 0 : Math.min(min, cuts[j-1] + 1);
            }
        }
        cuts[i] = min;
    }
    return cuts[s.length()-1];
    }
}
