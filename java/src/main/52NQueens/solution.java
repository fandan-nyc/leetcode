public class Solution {
    public int totalNQueens(int n) {
        if(n <= 0){
            return 0;
        }
        return helper(new HashSet<Integer>(), new HashSet<Integer>(), new HashSet<Integer>(), 0, n, 0); 
    }
    
    private int helper(Set<Integer> col, Set<Integer> diag1, Set<Integer> diag2, int row, int n, int count){
        for(int i  =0; i < n; i++){
            if(col.contains(i) || diag1.contains(i-row) || diag2.contains(i+row)){
                continue;
            }else{
                if(row == n-1){
                    return count+1;
                }
                else{
                    col.add(i);
                    diag1.add(i-row);
                    diag2.add(i+row);
                    count = helper(col, diag1, diag2, row+1,  n, count);
                    col.remove(i);
                    diag1.remove(i-row);
                    diag2.remove(i+row);
                }
            }
        }
        return count;
    }
}
