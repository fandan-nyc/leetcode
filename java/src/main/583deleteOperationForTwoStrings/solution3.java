public class Solution {
    
    private int[][] store;
    public int minDistance(String word1, String word2) {
        if(word1 == null || word2 == null){
            return -1;
        }
        store = new int[word1.length()+1][word2.length()+1];
        for(int i = 0; i < word1.length(); i++){
            for(int j = 0; j < word2.length();j++){
                if(word1.charAt(i) == word2.charAt(j)){
                    store[i+1][j+1] = store[i][j] +1;
                }else{
                    store[i+1][j+1] = Math.max(store[i+1][j],store[i][j+1]);
                }
            }
        }
        return word1.length() + word2.length() - 2* store[word1.length()][word2.length()];
    }
}
