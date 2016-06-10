public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        //recursive
        if(matrix == null|| matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int max = 1; 
        int[][] flag = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length;i++){
            for(int j = 0; j < matrix[0].length; j++){
                max = Math.max(traversal(matrix, i,j,flag), max);
            }
        }
        return max;
    }
    
    int traversal(int[][] matrix, int row, int column,  int [][] flag){
        if(row < 0 || column < 0 || row >= matrix.length || column >= matrix[0].length){
            return 0;
        }
        if(flag[row][column]!=0){
            return flag[row][column];
        }
        int curr = matrix[row][column];
        int len = 1;
        if(row > 0 && matrix[row-1][column] > curr){
            len = Math.max(1+ traversal(matrix, row-1,column, flag), len);
        }
        if(column > 0 && matrix[row][column-1] > curr){
            len = Math.max(1+ traversal(matrix, row,column-1, flag), len);
        }
        if(row < matrix.length -1 && matrix[row+1][column] > curr){
            len = Math.max(1+ traversal(matrix, row+1,column, flag), len);
        }
        if(column < matrix[0].length-1 && matrix[row][column+1] > curr){
            len = Math.max(1+ traversal(matrix, row,column+1,flag), len);
        }
        flag[row][column] = len;
        return len;
    }
}
