public class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int[][] store = new int[matrix.length][matrix[0].length];
        
        int max = 0 ;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(i == 0 || j == 0){
                    store[i][j] = matrix[i][j] - '0'; 
                }else if( matrix[i][j] == '1'){
                    store[i][j] = Math.min(store[i-1][j-1], Math.min(store[i-1][j], store[i][j-1]))+1;
                }
                max = Math.max(store[i][j], max);
            }
        }
        return max * max;
    }
}
