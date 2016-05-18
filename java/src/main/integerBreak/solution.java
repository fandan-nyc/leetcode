public class Solution {
    public int integerBreak(int n) {
        if(n <=2){
            return 1;
        }
        else if(n == 3){
            return 2;
        }else if(n == 4){
            return 4;
        }
        int prod =1;
        while(n > 4){
            prod *= 3;
            n-= 3;
        }
        if(n > 0){
            prod *= n;
        }
        return prod;
    }
}
