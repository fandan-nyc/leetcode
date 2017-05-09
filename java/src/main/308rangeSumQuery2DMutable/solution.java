public class NumMatrix {

    private final int[][] bit ; 
    private final int[][] data ;
    public NumMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            bit = null;
            data = null;
        }else {
            bit = new int[matrix.length][matrix[0].length+1];
            data = new int[matrix.length][matrix[0].length];
            for(int i = 0; i < matrix.length; i++){
                for(int j = 0; j < matrix[0].length; j++){
                    update(i, j, matrix[i][j]);
                }
            }
        }
    }
    
    public void update(int row, int col, int val) {
        int diff = val - this.data[row][col];
        this.data[row][col] = val; 
        int j = col+1;
        while(j <= data[0].length){
            bit[row][j] += diff;
            j += ( j & (-j));
        }
    }
    
    private int getSumSingleRow(int[] rowData, int pos){
        pos += 1;
        int sum = 0;
        while( pos > 0){
            sum += rowData[pos];
            pos -= (pos & (-pos));
        }
        return sum;
    }
    
    private int getSum(int row, int start, int end){
        return getSumSingleRow(this.bit[row],end) - getSumSingleRow(this.bit[row],start-1);
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int result  = 0; 
        for(int i = row1; i <= row2; i++){
            result += getSum(i, col1, col2);
        }
        return result;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */
