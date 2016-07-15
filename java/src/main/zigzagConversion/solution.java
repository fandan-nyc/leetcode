public class Solution {
    public String convert(String s, int numRows) {
        if(s == null || numRows >=s.length()|| numRows == 1){
            return s;
        }
        int divide = numRows * 2 -2;
        StringBuilder result = new StringBuilder();
        for(int j = 0; j < divide; j++){
            for(int i = 0 ; i < s.length(); i++){
                int mod = i % divide;
                if(mod  <  numRows &&  mod  == j ){
                    result.append(s.charAt(i));
                }
                else if(mod >= numRows && (divide - mod) == j){
                    result.append(s.charAt(i));
                }
            }
        }
        return result.toString();
    }
}
