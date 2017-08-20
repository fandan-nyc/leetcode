class Solution {
    boolean[] visited;
    public int numberOfPatterns(int m, int n) {
       visited = new boolean[9];
        int total = 0;
        for(int i = m; i <= n; i++){
            total += calc(-1, i);
        }
        return total;
    }
    
    private int calc(int start, int len){
        if(len == 0){
            return 1;
        }
        int total = 0;
        for(int i = 0; i < 9; i++){
            if(isValid(start, i)){
                visited[i] = true;
                total += calc(i, len-1);
                visited[i] = false;
            }
        }
        return total;
    }
    
    private boolean isValid(int prev, int b){
        // not visit
        if(visited[b]){
            return false;
        }
        // first
        if(prev == -1){
            return true;
        }
        //adjacent or knight move 
        // 01, 05 
        if( (prev+b) % 2 == 1){
            return true;
        }
        // diagnal 
        // 08, 26
        if( prev + b == 8){
            return visited[4];
        }
        // adjacent on diagnal 
        if( prev %3 != b%3 && prev /3 != b/3){
            return true;
        }
        // rest, 06, 02 
        return visited[(prev+b)/2];
    }
}

// 9 
// 5 5 5 5
