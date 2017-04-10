public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int tmp = 0 ; 
        for(int i =0; i < 32; i ++){
            if((n & 1) == 1){
                tmp = (tmp << 1) ^ 1;
            }
            else{
                tmp = (tmp << 1);
            }
            n = n >>> 1;
        }
        return tmp;
        
    }
}
