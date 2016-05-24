public class Solution {
    public void rotate(int[][] matrix) {
        // transpose, swap by vertical center line
        for(int i = 0; i < matrix.length; i ++)
            for(int j = i+1;j < matrix[0].length;j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        for(int i = 0; i < matrix.length; i++){
            for(int j = matrix[0].length/2; j < matrix[0].length; j++){
                 int tmp = matrix[i][j];
                 int mirrorColumn = matrix[0].length - j - 1;
                matrix[i][j] = matrix[i][mirrorColumn];
                matrix[i][mirrorColumn] = tmp;
            }
        }
    }
}
