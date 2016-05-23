public class Solution {
    public void solve(char[][] board) {
        for(int i = 0; i < board.length; i++)
            for(int j = 0;j < board[0].length; j++){
                if(i== 0 || i == board.length -1 || j ==0 || j == board[0].length -1){
                    if(board[i][j] == 'O'){
                        board[i][j] = 'M';
                        dfs(board, i, j);
                    }
                }
        }
        for(int i = 0; i < board.length;i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'O'){
                    board[i][j]='X'; 
                }
                else if(board[i][j] == 'M'){
                    board[i][j]='O'; 
                }
            }
        }
    }
    
    private void dfs(char[][] board, int i, int j){
        if(i+1<board.length-1 && board[i+1][j] == 'O'){
            board[i+1][j]='M';
            dfs(board, i+1, j);
        }        
        if(i-1> 0  && board[i-1][j] == 'O'){
            board[i-1][j]='M';
            dfs(board, i-1, j);
        }
        if(j+1<board[0].length-1 && board[i][j+1] == 'O'){
            board[i][j+1]='M';
            dfs(board, i, j+1);
        }
        if(j-1 > 0 && board[i][j-1] == 'O'){
            board[i][j-1]='M';
            dfs(board, i, j-1);
        }
    }
}
