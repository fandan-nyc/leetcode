public class Solution {
    public String parseTernary(String expression) {
       // find the last ? calc, replace the string by new value 
       while(expression.length() != 1){
           int i = expression.lastIndexOf("?");
           char tmp = expression.charAt(i-1) == 'T' ? expression.charAt(i+1): expression.charAt(i+3);
           expression = expression.substring(0,i-1) + tmp + expression.substring(i+4, expression.length());
       }
       return expression;
    }
}
