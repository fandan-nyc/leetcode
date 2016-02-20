public class Solution {
    public boolean isValidSudoku(char[][] board) {
        // assume that the board is < 16*16
        int check = 0; 
        int[] block= {0,0,0} ; 
        int rows = board.length; 
        int columns = board[0].length;
        // check rows && columns
        for(int i = 0; i < 9; i ++){
            check = 0 ;
            if(i == 0 || (i/3 != (i-1)/3)){
                Arrays.fill(block,0);
            }
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.'){
                    continue;
                } 
                int curr = 1 << (board[i][j] - '1') ;
                if((check & curr ) != 0 ){
                    return false;
                }else{
                    check = check | curr;
                }
                
                if( (curr & block[j/3]) != 0){
                    return false;
                }
                else {
                    block[j/3] = block[j/3] | curr;
                }
            }
        }
        
        for(int i  = 0; i < 9; i ++){
            check  = 0; 
            for(int j = 0; j < 9; j++){
                 if(board[j][i] == '.'){
                    continue;
                }
                int curr = 1 << (board[j][i] - '1') ;
                if((check & curr ) != 0){
                    return false;
                }else{
                    check = check | curr;
                }
            }
        }
        return true;
    }
}
