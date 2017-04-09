public class Solution {
    public boolean isPowerOfFour(int num) {
        if(num == 1){
            return true;
        }
        if(num == 0)
            return false;
        while( num != 1) {
            if(num % 4 != 0){
                return false;
            }
            num /= 4;
        }
        return true;
    }
// time complexity is O(log4(N)) and space complexity is O(1)
}
