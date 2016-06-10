public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        helper(n, result, 0,1);
        return result;
    }
    
    private void helper(int n, int[][] result, int startPos, int startNum){
        if(n <= 0){
            return;
        }
        result[startPos][startPos] = startNum;
        for(int i = startPos; i < startPos+n-1; i++){
            result[startPos][i] = startNum++;
        }
        for(int i = startPos; i < startPos+n-1; i++){
            result[i][startPos+n-1] = startNum++;
        }
        for(int i = startPos+n-1; i > startPos; i--){
            result[startPos+n-1][i] = startNum++;
        }
        for(int i = startPos+n-1; i > startPos; i--){
            result[i][startPos] = startNum++;
        }
        helper(n-2, result, startPos+1, startNum);
    }
}
