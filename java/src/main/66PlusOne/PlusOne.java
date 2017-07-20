public class Solution {
    public int[] plusOne(int[] digits) {
        int carryOver  = 1;
        for(int i = digits.length -1; i >= 0; i--)
        {
            int tmp =  digits[i];
            digits[i] = (digits[i] + carryOver) %10;
            carryOver = (tmp + carryOver > 9)? 1:0;
        }
        if(carryOver == 0)
        {
            return digits;
        }
        else
        {
            int[] tmp =  new int[digits.length+1];
            tmp[0] = 1;
            return tmp ;
        }
    }
}
