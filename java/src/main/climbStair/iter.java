public class Solution {
    public int climbStairs(int n) {
        int first = 1; 
        int second = 2;
        if(n == 0){
            return 0;
        }
        else if(n == 1){
            return first;
        }
        else if(n == 2){
            return second;
        }
        int i = 2;
        int total = first + second;
        while( i++< n){
            total = first  + second;
            first = second; 
            second= total;
        }
        return total;
    }
}
