public class Solution {
    public boolean detectCapitalUse(String word) {
        // assume all letters
        if(word == null || word.length() == 0){
            return false;
        }

        if(isLower(word.charAt(0))){
            return allLowerCase(word.substring(1));
        }
        else{
            return allCapitalCase(word.substring(1)) || allLowerCase(word.substring(1));
        }
        
    }
    
    private boolean allLowerCase(String a){
        for(int i = 0 ; i < a.length(); i++){
            if(!isLower(a.charAt(i))){
                return false;
            } 
        }
        return true;
    }
    
    private boolean allCapitalCase(String a){
         for(int i = 0 ; i < a.length(); i++){
            if(!isCapital(a.charAt(i))){
                return false;
            } 
        }
        return true;
    }
    
    private boolean isLower(char i){
        return i >= 'a' && i <= 'z';
    }
    
     private boolean isCapital(char i){
        return i >= 'A' && i <= 'Z';
    }
    
}
