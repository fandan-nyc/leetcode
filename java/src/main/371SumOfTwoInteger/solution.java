public class Solution {
    public int getSum(int a, int b) {
        int count = 0; 
        int carryOver = 0;
        int result = 0;
        while( count <= 31){
            int aBit = a & 1;
            int bBit = b & 1;
            a = a >>> 1;
            b = b >>> 1;
            int digit = aBit ^ bBit ^ carryOver;
            result |= digit<< count; 
            if(aBit== 1 && bBit == 1){
                carryOver = 1;
            }else if(aBit == 1 && carryOver == 1){
                carryOver = 1;
            }else if(bBit == 1 && carryOver == 1){
                carryOver = 1;
            }else{
                carryOver = 0;
            }
            count++;
        }
        return result;
    }
}
