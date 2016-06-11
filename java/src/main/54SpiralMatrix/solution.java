public class Solution{
       public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix == null ||  matrix.length == 0 ||matrix[0] == null || matrix[0].length == 0){
            return new ArrayList<Integer>();
        }
        List<Integer> result = new ArrayList<Integer>();
        int rowLow = 0;
        int columnLow = 0 ;
        int rowHigh = matrix.length -1;
        int columnHigh = matrix[0].length-1;
   
        while(rowLow <= rowHigh && columnLow <= columnHigh){
            for(int i = columnLow ; i <= columnHigh && rowLow <= rowHigh;  i++){
                result.add(matrix[rowLow][i]);
            }
            rowLow++;
            for(int i = rowLow ; i <= rowHigh && columnLow <= columnHigh;  i++){
                result.add(matrix[i][columnHigh]);
            }
            columnHigh--;
             for(int i = columnHigh; i >= columnLow && rowLow <= rowHigh; i--){
                result.add(matrix[rowHigh][i]);
            }
            rowHigh--;
             for(int i = rowHigh; i >=rowLow && columnLow <= columnHigh;  i--){
                result.add(matrix[i][columnLow]);
            }
            columnLow++;
        }
        return result;   
    }
}
