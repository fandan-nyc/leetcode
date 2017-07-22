public class Solution {
    public boolean checkRecord(String s) {
        int countAbsent = 0; 
        for(int i = 0; i < s.length() && countAbsent < 2; i++){
            if(s.charAt(i) == 'L'){
                if(failDueToLate(s, i)){
                    return false;
                }
            }else if(s.charAt(i) == 'A'){
                countAbsent ++;
            }
        }
        return countAbsent < 2;
    }
    
    private boolean failDueToLate(String s, int start){
        return (start+2 <= s.length()-1) && s.substring(start, start+3).equals("LLL");
    }
}
