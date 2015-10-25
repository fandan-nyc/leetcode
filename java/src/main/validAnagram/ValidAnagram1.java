public class Solution {
    public boolean isAnagram(String s, String t) {
        // if all lowercase alph
        int sum = 0 ; 
        int sProd = 1 ;   
        int tProd = 1 ;
        for(Character i : s.toCharArray())
        {
            sum += i ;
            sProd *= i;
        }
        for(Character i : t.toCharArray())
        {
           sum -= i;
           tProd *= i;
        }
        return sum == 0  && sProd == tProd;
    }
}e
