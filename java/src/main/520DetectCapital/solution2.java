public class Solution {
    public boolean detectCapitalUse(String word) {
        // assume all letters
        if(word == null || word.length() == 0){
            return false;
        }
        int count = 0; 
        for(char i: word.toCharArray()){
            count += ('Z' - i) >= 0? 1: 0;
        }
        return (count == 0 || count == word.length() || (count == 1 && word.charAt(0) >= 'A' && word.charAt(0) <= 'Z'));
    }
}
