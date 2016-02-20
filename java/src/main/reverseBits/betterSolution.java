public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int[] answer = {0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15};
        int tmp = 0;
        int counter = 7 ; 
        while(counter-- >= 0){
            tmp = tmp << 4;
            tmp |= answer[n & 15];
            n = n >> 4;
        }
        return tmp;
    }
}
