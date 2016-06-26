public class Solution {
    public int mySqrt(int x) {
        if(x == 0){
            return 0;
        }
        else if(x == 1 ){
            return 1;
        }
        double tmp = x/2;
        while(tmp*tmp -x > 0.000001){
            tmp = 0.5 * (tmp + x/tmp);
        }
        return (int)tmp;
    }
}
