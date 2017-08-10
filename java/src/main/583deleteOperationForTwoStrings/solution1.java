class Solution {
    public int minDistance(String word1, String word2) {
        if(word1 == null || word2 == null){
            return -1;
        }
        return word1.length() + word2.length() - 2 * longestCommon(word1,word2,word1.length(), word2.length());
    }
    
    private int longestCommon(String a, String b, int m, int n){
        if(m == 0|| n == 0){
            return 0;
        }
        if(a.charAt(m-1) == b.charAt(n-1)){
            return 1 + longestCommon(a, b, m-1, n-1);
        }else{
            return Math.max(longestCommon(a, b, m-1, n), longestCommon(a, b, m, n-1));
        }
    }
}
