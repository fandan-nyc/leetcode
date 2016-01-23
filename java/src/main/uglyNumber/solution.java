public class Solution {
    public boolean isUgly(int num) {
        if(num <= 0)
            return false;
        int[] divisor = new int[]{2,3,5};
        for(int i: divisor){
            while(num %i == 0){
                num /= i;
                }
            }
        return num == 1;
    }
}
