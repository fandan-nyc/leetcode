public class Solution {
    
    private int[] pos;
    private int[] size;
    
    public void solve(char[][] board) {
        if(board == null || board.length <=2 || board[0].length <= 2){
            return;
        }
        int m = board.length;
        int n = board[0].length;
        pos = new int[m*n];
        size = new int[m*n];
        Arrays.fill(size,1);
        int onEdge = -1;
        for(int i =0; i < m; i++){
            for(int j = 0; j < n;j++){
                if(board[i][j]=='X'){
                    continue;
                }
                int index = i*n + j;
                pos[index] = index;
                if(i==0 || i == m-1 || j ==0||j== n-1){
                    if(onEdge == -1){
                        onEdge=index;
                    }else{
                        unite(onEdge, index);
                    }
                }
                if(i >= 1 && board[i-1][j]=='O'){
                    unite(index-n, index);
                }
                if(j >= 1 && board[i][j-1] == 'O'){
                    unite(index-1, index);
                }
            }
        }
        for(int i  = 1; i < m-1;i++){
            for(int j =1; j < n-1;j++){
                if(board[i][j] == 'O'){
                    int index = i * n + j;
                    if(onEdge == -1 || !find(index, onEdge)){
                        board[i][j]= 'X';
                    }
                }
            }
        }
    }
    
    private int findRoot(int i){
        while(i != pos[i]){
            pos[i] =pos[pos[i]];
            i = pos[i];
        }
        return i;
    }
    
    private boolean find(int i, int j){
        return findRoot(i) == findRoot(j);
    }
    
    private void unite(int i, int j){
        int iRoot = findRoot(i);
        int jRoot = findRoot(j);
        if(size[i] < size[j]){
            pos[iRoot]=pos[jRoot];
            size[j] += size[i];
        }
        else{
            pos[jRoot]=pos[iRoot];
            size[i] += size[j];
        }
    }
}
