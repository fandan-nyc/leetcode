public class Solution {
    public int numWays(int n, int k) {
        if(n== 0 || k == 0){
            return 0;
        }
        int[] result = new int[n+1 > 3? n+1: 3];
        result[0] = 0;
        result[1] = k;
        result[2] = k*k;
        for(int i = 3; i < n+1;i++){
            result[i] = result[i-1] * (k-1) + result[i-2]* (k-1);
        }
        return result[n];
    }
}
