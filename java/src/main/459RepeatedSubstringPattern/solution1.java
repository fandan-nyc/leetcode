 class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int half = s.length()/2;
        for(int i = 1; i <= half; i++){
            if(s.length() %i != 0){
                continue;
            }
            String template = s.substring(0, i);
            if(isRepeatByPattern(s, template)){
                return true;
            }
        }
        return false;
    }
    
    private boolean isRepeatByPattern(String original, String template){
        for(int j = i; j < s.length(); j+= i){
            if(!s.substring(j, j+i).equals(tmp)){
                return false;
            }
        }
        return true;
    }
}
