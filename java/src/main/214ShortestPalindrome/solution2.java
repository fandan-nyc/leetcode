public class Solution {
    public String shortestPalindrome(String s) {
         if(s == null || s.length() <= 1){
             return s;
         }
         char[] sArr = s.toCharArray();
        int middle = (s.length() -1)/2;
        int end = 1;
        end = getLastPosForPalindrome(sArr, middle);
       StringBuilder sb = new StringBuilder();
       for(int k = s.length()-1; k >= end; k--){
           sb.append(sArr[k]);
       }
       return sb.toString() + s ;
    }
    
   private int getLastPosForPalindrome(char[] s, int middle){
       int i = middle;
       int j = middle;
       while(i >= 0 && s[i] == s[middle]){
           i--;
        }
        while(j < s.length && s[j] == s[middle]){
            j++;
            
        }
        while(i >=0 && j < s.length && s[i] ==  s[j]){
            i--; 
            j++;
        }
        if(i == -1){
            return j;
        }
        return getLastPosForPalindrome(s, middle -1);
   }
}
