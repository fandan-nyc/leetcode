public class Solution {
    public int numSquares(int n) {
        int[] data = new int[n+1];
        Arrays.fill(data, Integer.MAX_VALUE);
        data[0] = 0;
        data[1] = 1;
        for(int i = 2; i <= n; i++){
            for(int j = 1; j*j <= i; j++){
                data[i] = Math.min(data[i], data[i-j*j] +1);
            }
        }
        return data[n];
    }
}
