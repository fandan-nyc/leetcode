public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> number = new Stack<Integer>(); 
        for(String i: tokens){
            if(isOperator(i)){
                calculate(number, i);
            }
            else{
                number.push(strToInt(i));
            }
        }
        assert number.isEmpty() == false && number.size() == 1;
        return number.pop();
    }
    
    private int strToInt(String input){
        int result  = 0;
        int sign = 1;
        if(input.charAt(0) == '-'){
            sign = -1;
            input = input.substring(1);
        }
        for(char i: input.toCharArray()){
            result = result * 10 + i - '0';
        }
        return result * sign;
    }
    
    private boolean isOperator(String s){
        return s.equals("+") || s.equals("-")|| s.equals("*") || s.equals("/");
    }
    
    private void calculate(Stack<Integer> num, String s){
        int first = num.pop(); 
        int second = num.pop();
        if(s.equals("+")){
            num.push(first +  second);   
        }else if(s.equals("-")){
            num.push(second - first);   
        }else if(s.equals("*")){
            num.push(first *  second);   
        }else if(s.equals("/")){
            num.push(second / first);   
        }
        return;
    }
}
