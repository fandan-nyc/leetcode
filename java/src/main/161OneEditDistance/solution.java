public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if(s == null || t == null){
            return false;
        }
        int lenDiff = s.length() - t.length();
        if(lenDiff > 1|| lenDiff < -1 ){
            return false;
        }
        else if(lenDiff == 0){
            return oneCharModify(s,t);
        }else {
            return oneCharDel(s,t);   
        }
    }
    
    private boolean oneCharDel(String a, String b){
        if(a.length() > b.length()){
            return oneCharDel(b,a);
        }
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i)!= b.charAt(i)){
                return a.substring(i).equals(b.substring(i+1));
            }
        }
        return true;
    }
    
    private boolean oneCharModify(String a, String b){
        int diff = 0;
        for(int i = 0 ; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i)){
                diff++;
            }
            if(diff > 1){
                return false;
            }
        }
        return diff == 1;
    }
}
