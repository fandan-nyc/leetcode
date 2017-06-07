public class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
         int[] result = new int[length];
         for(int[] op: updates){
             int start = op[0];
             int end = op[1];
             int eval = op[2];
             result[start] += eval;
             if(end+1 < length)
                result[end+1] -= eval; 
         }
         for(int i = 1; i < length; i++){
             result[i] = result[i] + result[i-1];
         }
         return result;
    }
}
