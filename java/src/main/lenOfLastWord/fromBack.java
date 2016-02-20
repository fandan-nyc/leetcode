public class Solution {
    public int lengthOfLastWord(String s) {
        int i = s.length() -1; 
        while( i >= 0  && s.charAt(i) == ' '){
            i--;
        }
        if(i < 0){
            return 0;
        }
        int counter = 0 ;
        while( i >= 0 && s.charAt(i) != ' '){
            counter ++;
            i--;
        }
        return counter;
    }
}
