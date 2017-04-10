public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int tmp = 0;
        for(int i= 0 ; i < 32; i ++){
            tmp += (n & 1) << (31 - i);
            n = n >>> 1;
        }
        return tmp;
    }
}
