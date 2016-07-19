public class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set[] rows = new Set[board.length];
        Set[] cols = new Set[board.length];
        Set[] block = new Set[board.length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                final char curr = board[i][j];
                if(curr == '.'){
                    continue;
                }
                if(rows[i] == null){
                    rows[i] = new HashSet<Integer>();
                }
                if(rows[i].contains(curr)){
                    return false;
                }
                rows[i].add(curr);
                if(cols[j] == null){
                    cols[j] = new HashSet<Integer>();
                }
                if(cols[j].contains(curr)){
                    return false;
                }
                cols[j].add(curr);
                int blockNum = (j/3)+(i/3)*3;
                if(block[blockNum] == null){
                    block[blockNum] = new HashSet<Integer>();
                }
                if(block[blockNum].contains(curr)){
                    return false;
                }
                block[blockNum].add(curr);
            }
        }
        return true;
    }
}
