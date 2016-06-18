public class Solution {
    public int minDistance(String word1, String word2) {
        if(word1 == null || word2 == null)
            return 0;
        if(word1.length() ==0)
            return word2.length();
        else if(word2.length() == 0)
            return word1.length();
        int[][] matrix = new int[word1.length()+1][word2.length()+1];
        for(int i = 0;i <= word1.length();i++){
            matrix[i][0]= i;
        }
        for(int j = 0; j <= word2.length(); j++){
            matrix[0][j]= j;
        }
        for(int i = 1; i <= word1.length();i++){
            for(int j = 1; j <= word2.length();j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    matrix[i][j]= matrix[i-1][j-1];
                }
                else{
                    matrix[i][j] = Math.min(matrix[i-1][j], Math.min(matrix[i][j-1], matrix[i-1][j-1])) +1;
                }
            }
        }
        return matrix[word1.length()][word2.length()];        
    }
}
