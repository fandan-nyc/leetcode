public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int[] col = new int[matrix.length];
        for(int i =0; i < matrix.length; i++){
            col[i] = matrix[i][0];
        }
        int row = binarySearch(col, target);
        if( row < matrix.length && matrix[row][0] == target){
            return true;
        }
        if(row == 0){
            return false;
        }
        row = row -1;
        int colPos = binarySearch(matrix[row], target);
        if( colPos == matrix[0].length || matrix[row][colPos] != target){
            return false;
        }
        return true;
    }
    
    int binarySearch(int[] data, int target){
        int start = 0;
        int end = data.length-1;
        while(start <= end){
            int middle = start + (end-start) /2;
            if(data[middle] == target){
                return middle;
            }else if(data[middle] > target){
                end = middle-1;
            }else{
                start = middle+1;
            }
        }
        return start;
    }
}
