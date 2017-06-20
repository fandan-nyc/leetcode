public class Solution {
    public int lengthOfLastWord(String s) {
        int result = 0;
        s = s.trim();
        if(s == null || s.length() == 0){
            return result;
        }
        for(char i: s.toCharArray()){
            if(i == ' '){
                result = 0;
            }else{
                result++;
            }
        }
        return result;
    }
}
// another solution one line
public class Solution {
    public int lengthOfLastWord(String s) {
        return s.trim().length() - s.trim().lastIndexOf(" ") -1;
    }
}
