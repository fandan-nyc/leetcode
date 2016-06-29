public class Solution {
    public String shortestPalindrome(String s) {
         if(s == null || s.length() <= 1){
             return s;
         }
         char[] sArr = s.toCharArray();
         int endingPosition = 0;
         for(int i = sArr.length-1; i >= 0; i--){
             if(isPalindrome(sArr, i)){
                 endingPosition = i;
                 break;
             }
         }
         StringBuilder sb = new StringBuilder();
         for(int i = s.length()-1; i > endingPosition; i--){
             sb.append(sArr[i]);
         }
         return sb.toString()+s;
    }
    
    private boolean isPalindrome(char[] s, int end){
        int start  = 0; 
        while(start < end){
            if(s[start] != s[end]){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
