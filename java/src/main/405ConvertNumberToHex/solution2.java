public class Solution {
    public String toHex(int num) {
        String result = "";
        for(int i = 0; i < 8; i++){
            result = numToChar(num >>> (4 * i)) + result;
        }
        return truncateZero(result);
    }
    
    private String truncateZero(String input){
        String output = "";
        boolean removeZero = true;
        for(int i= 0 ; i < input.length();i++){
            if(input.charAt(i) != '0'){
                removeZero = false;
            }
            if(removeZero == false){
                output += input.charAt(i);
            }
        }
        
        if(output.length() == 0){
            return "0";
        }
        return output;
    }
    
    private char numToChar(int input){
        int tmp = input & 0xf;
        if(tmp < 10){
            return (char)('0' + tmp);
        }else{
            return (char)('a' + tmp-10);
        }
    }
}
