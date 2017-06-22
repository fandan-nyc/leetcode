public class Solution {
    public String addStrings(String num1, String num2) {
        if(num1 == null || num1.length() == 0){
            return num2;
        }else if(num2 == null || num2.length() ==0){
            return num1;
        }
        int num1Len = num1.length()-1;
        int num2Len = num2.length()-1;
        int carryOver = 0;
        StringBuilder result = new StringBuilder();
        while(num1Len >= 0 || num2Len >= 0){
            int first = num1Len < 0? 0: num1.charAt(num1Len)-'0';
            int second = num2Len < 0? 0: num2.charAt(num2Len)-'0';
            int tmp = (first+second+carryOver) % 10;
            carryOver = (first+second+carryOver)/10;
            result.insert(0, tmp);
            num1Len --;
            num2Len --;
        }
        if(carryOver == 1){
            result.insert(0, carryOver);
        }
        return result.toString();
        
    }
}
