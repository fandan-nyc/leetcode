public class Solution {
    public int climbStairs(int n) {
        // step(n) = step(n-2) + step(n-1)
        if(n <= 1){
            return 1;
        }else if(n == 2){
            return 2;
        }
        int first = 1; 
        int second = 2;
        for(int i = 3; i <= n ; i++){
            int tmp = first+ second;
            first  = second;
            second = tmp;
          
        }
        return second;
    }
}
