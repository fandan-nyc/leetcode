public class TicTacToe {


    int[] rows; 
    int[] cols;
    int diagnal; 
    int antiDiagnal;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        diagnal = 0;
        antiDiagnal = 0;
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
        int score = player == 1 ? 1: -1;
        moveHelper(score, row, col);
        return winning(score, row, col) ? player: 0;
    }
    
    private void moveHelper(int score, int row, int col){
        rows[row] += score;
        cols[col] += score;
        diagnal += ((row == col)? score: 0);
        antiDiagnal += ((row + col == rows.length-1) ? score: 0);
    }
    
    private boolean winning(int score, int row, int col){
        return rows[row] == rows.length * score || cols[col] == cols.length * score || diagnal == rows.length * score 
        || antiDiagnal == rows.length * score;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
