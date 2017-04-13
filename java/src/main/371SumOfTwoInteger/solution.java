public class Solution {
    public int getSum(int a, int b) {
        int carryOver = 0;
        int result = 0; 
        for(int i = 0; i < 32; i++){
            int aTmp = a & 1;
            int bTmp = b & 1;
            int currentDigit =  aTmp ^ bTmp ^ (carryOver);
            result |= currentDigit << i;
            a >>>= 1;
            b >>>= 1;
            carryOver = ( aTmp & bTmp) | (aTmp & carryOver) | (bTmp & carryOver); 
        }
        return result;
    }
}
