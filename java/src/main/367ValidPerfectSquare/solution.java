public class Solution {
    public boolean isPerfectSquare(int num) {
        if(num < 0){
            return false;
        }
        long start = 1;
        long end = num;
        while( start <= end){
            long middle = start + (end - start) /2;
            long tmp = middle * middle;
            if(tmp  == num){
                return true;
            }else if(tmp < num){
                start = middle+1;
            }else {
                end = middle -1;
            }
        }
        return false;
    }
}
