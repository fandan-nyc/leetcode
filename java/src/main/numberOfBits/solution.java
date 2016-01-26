public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int counter  = 0;
        for(int i = 0; i < 32; i++){
            counter += (((1<<i) & n) == 0  ? 0:1);
        }
        return counter;
    }
}
