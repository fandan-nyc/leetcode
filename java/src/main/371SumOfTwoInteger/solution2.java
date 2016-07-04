public class Solution {
    public int getSum(int a, int b) {
        if((a & b )== 0){
            return a|b;
        }
        return getSum(a^b, (a&b) <<1);
    }
}
