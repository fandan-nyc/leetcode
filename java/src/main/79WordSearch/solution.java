public class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                boolean result = helper(board, word, 0, i, j,0);
                if(result){
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean helper(char[][] board, String word, int wordPos, int row, int column, int counter){
        if( board[row][column] != word.charAt(wordPos)){
            return false;
        }else if(counter == word.length()-1){
            return true;
        }else{
            boolean result = false;
            char tmpChar = board[row][column];
            board[row][column] = 0;
            if(row > 0){
                result = result || helper(board, word, wordPos+1, row-1, column, counter+1);
            }      
            if(column >0){
                result = result || helper(board, word, wordPos+1, row, column-1, counter+1);
            }
            if(row < board.length-1){
               result = result || helper(board, word, wordPos+1, row+1, column, counter+1);
            }
            if(column < board[0].length-1 ){
                result = result || helper(board, word, wordPos+1, row, column+1, counter+1);
            }
            board[row][column] = tmpChar;
            return result;
        }
    }
}
