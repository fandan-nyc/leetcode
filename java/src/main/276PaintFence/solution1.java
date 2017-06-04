public class Solution {
    public int numWays(int n, int k) {
        int result = 1;
        
        if(n == 0|| k == 0){
            return 0;
        }else if (n == 1){
            return k;
        }else if(n == 2){
            return k*k;
        }else {
            return numWays(n-1,k) * (k-1) + numWays(n-2,k) * (k-1);
        }
    }
}
