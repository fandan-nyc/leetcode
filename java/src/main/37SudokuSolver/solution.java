public class Solution {
    public void solveSudoku(char[][] board) {
        int size = board.length;
        boolean[][] row = new boolean[size][size+1];
        boolean[][] col = new boolean[size][size+1];
        boolean[][] block = new boolean[size][size+1];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                char number = board[i][j];
                if(number ==  '.'){
                    continue;
                }
                row[i][number - '0'] = true;
                col[j][number - '0'] = true;
                block[getBlockNumber(i,j)][number -'0'] = true;
            }
        }
       solve(board, row, col, block, 0,0);
    }
    
    private boolean solve(char[][]board, boolean[][] row, boolean[][] col, boolean[][] block, int i, int j){
        if(i >= board.length){
            return true;
        }else if(board[i][j] != '.'){
            return solveNext(board, row, col, block, i,j);
        }else{
            List<Integer> list = getAvailableNums(row, col, block, i,j);
            if(list.isEmpty()){
                return false;
            }
            else{
                for(int candidate: list){
                    board[i][j] = (char)('0'+ candidate);
                    row[i][candidate] = true;
                    col[j][candidate] = true;
                    block[getBlockNumber(i,j)][candidate] = true;
                    boolean tmResult = solveNext(board, row, col, block, i, j);
                    if(tmResult){
                        return true;
                    }
                    else{
                        board[i][j] = '.';
                        row[i][candidate] = false;
                        col[j][candidate] = false;
                        block[getBlockNumber(i,j)][candidate] = false;
                    }
                }
                return false;
            }
        }
    }
    
    
    private boolean solveNext(char[][]board, boolean[][] row, boolean[][] col, boolean[][] block, int i, int j){
        if(j == board[0].length-1){
            return solve(board, row, col, block, i+1, 0);
        }else{
            return solve(board, row, col, block, i, j+1);
        }
    }
    

    private List<Integer> getAvailableNums(boolean[][] row, boolean[][] col, boolean[][] block, int i, int j){
        List<Integer> result = new ArrayList<Integer>();
        int blockNum = getBlockNumber(i, j);
        for(int m =1; m < row[0].length; m++){
            if(!row[i][m] && !col[j][m] && !block[blockNum][m]){
                result.add(m);
            }
        }
        return result;
    }
    
    private int getBlockNumber(int i, int j){
        return i/3 *3 + j/3;
    }
}
