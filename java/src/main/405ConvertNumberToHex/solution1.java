public class Solution {
    public String toHex(int num) {
       if(num == 0 ){
           return "0";
       }
       return helper(num, "");
    }
    
    private String helper(int number, String result){
        if(number == 0)
            return result;
        return helper(number >>> 4,  numToChar(number & 15) + result);
    }
    
    private char numToChar(int number){
        if(number < 10)
            return (char)('0' + number);
        else
            return (char)('a' + number - 10);
    }    
}
