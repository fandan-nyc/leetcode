public class TicTacToe {

    int[][] data ; 
    int winning ;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        data = new int[n][n];
        winning = 0;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        data[row][col] = player;
        boolean diagonal = false;
        if( row == col ){
                diagonal = diagonal || checkLeftDiagonal(player);
        }
        if(row + col == data.length -1){
                diagonal = diagonal || checkRightDiagonal(player);

        }
         if(checkRow(row, player) || checkColumn(col, player) || diagonal){
             return player;
         }
        return 0;
    }
    
    private boolean checkRow(int row, int player){
        for(int i = 0 ; i < data.length; i++){
            if(data[row][i] != player){
                return false;
            }
        }
        return true;
    }
    
     private boolean checkColumn(int column, int player){
        for(int i = 0 ; i < data.length; i++){
            if(data[i][column] != player){
                return false;
            }
        }
        return true;
    }
    
    private boolean checkLeftDiagonal(int player){
        int max = data.length -1 ;
        for(int i = 0; i < data.length; i++){
            if(data[i][i] != player){
                return false;
            }
        }
        return true;
    }
    
    private boolean checkRightDiagonal(int player){
        int max = data.length -1 ;
        for(int i = 0; i < data.length; i++){
           if(data[i][max-i] != player){
                return false;
            }
        }
        return true;
    }
      
            
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
