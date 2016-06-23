public class Solution {
    Stack<Integer> num = new Stack<Integer>();
    Stack<Character> op =  new Stack<Character>();
        
    public int calculate(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        
        char[] chars = s.toCharArray();
        for(int i = 0; i < s.length(); i++){
            char tmp = chars[i];
            if(tmp == ' '){
                continue;
            }
           
            if( tmp == '(' || tmp == '*' || tmp == '/') {
                op.push(tmp);
                continue;
            }
            
            if(tmp == '+' || tmp == '-'){
                if(!op.isEmpty() && op.peek() != '('){
                    calc();
                }
                op.push(tmp);
                continue;
            }
            
            if(tmp == ')'){
                while(op.peek() != '('){
                    calc();
                }
                op.pop();
                continue;
            }
            
            int number = 0;
            while(i < chars.length && chars[i] >= '0' && chars[i] <= '9'){
                number = number * 10 + (chars[i] - '0');
                i++;
            }
            num.push(number);
            if( op.isEmpty() == false && (op.peek() == '*' || op.peek() == '/')){
                   calc();    
            }
            i--;
        }
    
        while(!op.isEmpty() && op.peek() != '('){
            calc();
        }
        return num.peek();
    }
    
    private void calc(){
        int b = num.pop();
        int a = num.pop();
        char operator = op.pop();
        num.push(calc(a, b, operator));
        return;
    }
    
    private int calc(int a, int b, char op){
        if(op == '+'){
            return a+b;
        }else if(op == '-'){
            return a-b;
        }else if(op == '*'){
            return a*b;
        }else {
            return a/b;
        }
    }    
}
