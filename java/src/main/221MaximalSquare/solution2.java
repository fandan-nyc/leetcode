public class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int[] store = new int[matrix[0].length];
        
        int max = 0 ;
        int prev = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                int tmp = store[j];
                if(j == 0){
                    store[j] = matrix[i][j] - '0';
                }
                else if(matrix[i][j] == '0'){
                    store[j] = 0;
                }else {
                    store[j] = Math.min(prev, Math.min(store[j], store[j-1]))+1;
                }
                prev = tmp;
                max = Math.max(store[j], max);
            }
        }
        return max * max;
    }
}
