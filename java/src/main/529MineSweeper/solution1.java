class Solution {
    private int boardRow;
    private int boardCol;
    public char[][] updateBoard(char[][] board, int[] click) {
        boardRow = board.length;
        boardCol = board[0].length;
        int row = click[0];
        int col = click[1];
        if(board[row][col] == 'M'){
            board[row][col] = 'X';
            return board;
        }
        int num = numOfMine(row, col, board);
        if(num != 0){
            board[row][col] = (char)( num + '0');
            return board;
        }
        board[row][col] = 'B';
        for(int i  = -1; i <= 1; i++){
            for(int j = -1; j <= 1; j++){
                if(valid(row+i, col+j) && board[row+i][col+j] =='E'){
                    board = updateBoard(board, new int[]{row+i, col+j});
                }
            }
        }
        return board;
    }
    
    private boolean valid(int a, int b){
        return a >= 0 && a < boardRow && b >= 0 && b < boardCol;
    }
    
    private boolean isMine(char[][] board, int a, int b ){
        return board[a][b] == 'M' || board[a][b] == 'X';
    }
    
    private int numOfMine(int row, int col, char[][] board){
        int counter = 0;
        for(int i = -1; i <= 1; i++){
            for(int j = -1; j <= 1; j++){
                if(valid(row+i, col+j) && isMine(board, row+i, col+j)){
                    counter ++;
                }
            }
        }
        return counter;
    }
}
