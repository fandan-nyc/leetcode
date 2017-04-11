public class Solution {
    public int[] countBits(int num) {
        int[] result = new int[num+1];
        result[0] = 0;
        int currentPowerOfTwo = 0;
        for(int i= 1; i <= num; i++){
            if( (i & (i-1)) == 0){
                result[i] = 1;
                currentPowerOfTwo = i;
            }
            else{
                result[i] = 1 + result[i-currentPowerOfTwo];
            }
        }
        return result;
    }
}
