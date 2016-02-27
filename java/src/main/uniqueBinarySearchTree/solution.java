public class Solution {
    public int numTrees(int n) {
        int[] record = new int[n+1];
        record[0] = 1;
        record[1] = 1;
        for(int i = 2; i <= n; i++){
            int tmp = 0 ;
            for(int j = 0; j < i; j++){
                tmp += (record[j] * record[i-j-1]);
            }
            record[i] = tmp;
        }
        return record[n];
    }
}
