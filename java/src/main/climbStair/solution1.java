public class Solution {
    public int climbStairs(int n) {
        // step(n) = step(n-2) + step(n-1)
        if(n <= 1){
            return 1;
        }else if(n == 2){
            return 2;
        }
        return climbStairs(n-2) + climbStairs(n-1);
    }
}
