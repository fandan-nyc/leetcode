public class NumMatrix {
    
    private int[][] dp = null;
    public NumMatrix(int[][] matrix) {
        if(matrix != null && matrix.length != 0 && matrix[0].length !=0){
            dp=new int[matrix.length][matrix[0].length];
            prepareDP(matrix);
        }
    }
    
    private void prepareDP(int matrix[][]){
        for(int i = 0; i < matrix.length; i++)
            for(int j = 0; j < matrix[0].length;j++){
                int up = i > 0 ? dp[i-1][j]:0;
                int left = j > 0 ? dp[i][j-1]:0;
                int upperLeft = (i > 0 && j > 0)?dp[i-1][j-1]:0;
                this.dp[i][j] = matrix[i][j] +up + left - upperLeft;
            }
    }
    
    

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(dp == null){
            return 0;
        }
        int left = col1 > 0 ? dp[row2][col1-1]:0;
        int up = row1 > 0 ? dp[row1- 1][col2]:0;
        int upperLeft = col1 > 0 && row1 > 0? dp[row1-1][col1-1]:0;
        return dp[row2][col2] - left - up + upperLeft;
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);
