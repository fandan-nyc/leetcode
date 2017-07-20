public class Solution {
    public int[] plusOne(int[] digits) {
        int lastNotNine = getLastNotNineDigit(digits);
        if(lastNotNine == -1){
            int[] res = new int[digits.length+1];
            res[0] = 1;
            return res;
        }else{
            digits[lastNotNine]++;
            for(int i = lastNotNine+1; i < digits.length; i++){
                digits[i] = 0;
            }
            return digits;
        }
    }
    
    private int getLastNotNineDigit(int[] digits){
        int lastNotNine = -1;
        for(int i = 0; i < digits.length; i++){
            if(digits[i] != 9){
                lastNotNine = i;
            }
        }
        return lastNotNine;
    }
}
