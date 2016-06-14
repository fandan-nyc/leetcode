public class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0 ){
            return 0;
        }
        int result  = 0;
        int first = 1;
        int second = 1;
        for(int i = 0; i < s.length();i++){
            result = 0;
            if(s.charAt(i) != '0'){
                result += first;
            }
            if(i > 0 && isWord(s.charAt(i-1), s.charAt(i))){
                result += second;
            }
            second = first; 
            first = result;
        }
        return result;
    }
    
    private boolean isWord(char a, char b){
        return (a=='2' && b <= '6')|| (a == '1');
    }
}
