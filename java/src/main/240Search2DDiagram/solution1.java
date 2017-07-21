public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix ==null || matrix.length == 0 || matrix[0].length ==0){
            return false;
        }
        for( int[] i: matrix){
            if(target > i[i.length-1]){
                continue;
            }else if(target < i[0]){
                return false;
            }else if(binarySearch(i, target)){
                return true;
            }
        }
        return false;
    }
    
    
    private boolean binarySearch(int[] data, int target){
        int start  = 0; 
        int end = data.length -1;
        while(start <= end){
            int middle = start + (end - start)/2;
            if(data[middle] == target){
                return true;
            }else if ( data [middle] < target){
                start = middle+1;
            }else{
                end = middle -1;
            }
        }
        return false;
    }
    
}
