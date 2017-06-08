public class Solution {
    public int climbStairs(int n) {
        // step(n) = step(n-2) + step(n-1)
        if(n <= 1){
            return 1;
        }else if(n == 2){
            return 2;
        }
        int[] result = new int[n+1];
        result[1] = 1; 
        result[2] = 2;
        for(int i = 3; i <= n ; i++){
            result[i] = result[i-1] + result[i-2];
        }
        return result[n];
    }
}
