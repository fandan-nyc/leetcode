public class Solution {
    public void gameOfLife(int[][] board) {
        //brute force, space complexity O(m*n) 
        // time complexity O(m*n)
        int row = board.length;
        int column = board[0].length;
        for(int i = 0; i < board.length;i++){
            for(int j = 0; j <board[0].length;j++){
                int result = result(board,i,j);
                if(result == 1 && board[i][j] == 0){
                    board[i][j] = -1;
                }else if(result == 0 && board[i][j]== 1){
                    board[i][j] = 2;
                }
            }
        }
        for(int i =0; i < board.length;i++){
            for(int j =0; j<board[0].length;j++){
                if(board[i][j] == -1){
                    board[i][j] = 1;
                }else if(board[i][j] == 2){
                    board[i][j] = 0;
                }
            }
        }
    }
    
    private int result(int[][] board, int i, int j){
        //up
        int res = 0;
        if(i > 0 && board[i-1][j] >0 ){
            res ++;
        }
        //left
        if(j > 0 && board[i][j-1] > 0){
            res++;
        }
        //down
        if(i < board.length -1 &&board[i+1][j] >0 ){
            res ++;
        }
        // right 
        if(j < board[0].length -1 && board[i][j+1] >0){
            res ++;
        }
        // diagnal-left-up
        if(i > 0 && j > 0 && board[i-1][j-1] >0){
            res ++;
        }
         // diagnal-left-up
        if(i > 0 && j < board[0].length-1 && board[i-1][j+1] > 0){
            res ++;
        }
        //diagnal-left-down
        if(i < board.length-1 && j >0 && board[i+1][j-1] > 0){
            res ++;
        }
        // diagnal-right-down
        if(i < board.length-1 && j < board[0].length-1 && board[i+1][j+1] >0){
            res ++;
        }
        if(board[i][j] == 1 && (res== 2 || res == 3)){
            return 1;
        }else if(board[i][j] == 0 && res == 3){
            return 1;
        }
        return 0;
    }
}
