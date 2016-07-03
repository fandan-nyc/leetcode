public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<List<String>>();
        if(n <= 0){
            return result;
        }
        boolean[] columnOccupied = new boolean[n];
        char[][] board =  new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }
        helper(result, new ArrayList<String>() , board, columnOccupied, 0);
        return result;
    }
    
    private void helper(List<List<String>> result, List<String> tmp, char[][] board, boolean[] columnOccupied, int row){
        if(row == board.length && tmp.size() == board.length){
            result.add(new ArrayList<String>(tmp));
            return ;
        }
        for(int j = 0; j < board[0].length; j++){
            if(isValid(board, columnOccupied, row, j)){
                board[row][j] = 'Q';
                columnOccupied[j] = true;
                tmp.add(new String(board[row]));
                helper(result, tmp, board, columnOccupied, row+1);
                columnOccupied[j] = false;
                tmp.remove(tmp.size()-1);
                board[row][j] = '.';
            }
        }
    }
    
    private boolean isValid(char[][] board, boolean[] columnOccupied, int i, int j){
        if(columnOccupied[j] == true){
            return false;
        }
        for(int t = 1; i -t >= 0 && j-t >=0;t++){
            if(board[i-t][j-t] == 'Q'){
                return false;
            }
        }
        for(int t = 1; i + t < board.length && j-t >=0;t++){
            if(board[i+t][j-t] == 'Q'){
                return false;
            }
        }
        for(int t = 1; i + t < board.length && j + t < board[0].length;t++){
            if(board[i+t][j+t] == 'Q'){
                return false;
            }
        }
        for(int t = 1; i -t >= 0 && j + t < board[0].length;t++){
            if(board[i-t][j+t] == 'Q'){
                return false;
            }
        }
        return true;
    }
}
