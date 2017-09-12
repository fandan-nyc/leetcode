class Solution {
    public int[][] imageSmoother(int[][] M) {
        if(M == null || M.length == 0 || M[0].length == 0){
            return M;
        }
        int row = M.length;
        int col = M[0].length;
        for(int i  = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                avg(M, i, j);
            }
        }
        for(int i  = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                M[i][j] = M[i][j] >> 8;
            }
        }
        return M;
    }
    
    private void avg(int[][] matrix, int x, int y){
        int counter = 0;
        int sum = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        for(int i = -1; i <= 1; i++){
            for(int j = -1; j <= 1 ; j++){
                if( isValid(x+i, y+j, row, col)){
                    sum += matrix[x+i][y+j] & 0xFF;
                    counter ++;
                }
            }
        }
        matrix[x][y] |= (sum / counter) << 8;
    }
    
    private boolean isValid(int x, int y, int row, int col){
        return x >= 0 && x < row && y >= 0 && y < col;
    }
}
