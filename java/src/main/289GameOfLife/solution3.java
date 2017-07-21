public class Solution {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0){
            return;
        }
      
        for(int i = 0 ; i < board.length; i++){
            for(int j = 0 ; j < board[0].length; j++){
                game(board, i, j);
            }
        }
        translate(board);
    }
    
    private void game(int[][] board, int a, int b){
        int number = neighbours(board, a, b);
        if(isAlive(board, a, b)){
            if(number < 2 || number > 3){
                kill(board, a, b);
            }else{
                keepAlive(board, a, b);
            }
        }else if(number == 3){
            reproduce(board, a, b);
        }
    }
    
    private boolean isAlive(int[][]board, int a, int b){
        return (board[a][b] & 1) == 1;
    }
    
    
    
    private void kill(int[][] board, int a, int b){
        
    }
    
    private void reproduce(int[][] board, int a, int b){
         board[a][b] = 2;
    }
    
    private void keepAlive(int[][]board, int a, int b){
        board[a][b] = 3;
    }
    
    private int neighbours(int[][]board, int a, int b){
        int total = 0 ; 
        int[] rowBound = getBound(board, a, true);
        int[] colBound = getBound(board, b, false);
        for(int i = rowBound[0]; i <= rowBound[1]; i++){
             for(int j = colBound[0]; j <= colBound[1]; j++){
                 if( !(a == i && j == b))
                    total += (board[i][j] & 1);
             }
        }
        return total;
    }
    
    private int[] getBound(int[][] board, int a, boolean isRow){
        int[] leftRight = new int[2];
        leftRight[0] = a -1 > 0 ? a-1:0;
        if(isRow){
            leftRight[1] =  a < board.length-1 ? a+1: board.length-1;
        }else{
            leftRight[1] =  a < board[0].length-1 ? a+1: board[0].length-1;
        }
        return leftRight;
    }
    
    private void translate(int[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                board[i][j] = board[i][j] >> 1;
            }
        }
    }
}
