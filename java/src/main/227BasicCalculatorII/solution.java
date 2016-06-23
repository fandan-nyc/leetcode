public class Solution {
    Stack<Integer> num =  new Stack<Integer>(); 
    Stack<Character> op = new Stack<Character>();
    
    
    public int calculate(String s) {
        // no parenthesis
        char[] sArr = s.toCharArray();
        for(int i = 0; i < sArr.length; i++){
            char tmp = sArr[i];
            if(tmp == ' '){
                continue;
            }
            if(tmp >= '0' && tmp <= '9'){
                int number = 0;
                while(i < sArr.length && sArr[i] >= '0' && sArr[i] <= '9'){
                    number = number * 10 + sArr[i] - '0';
                    ++i;
                }
                num.push(number);
                if(!op.isEmpty() && (op.peek() == '*' || op.peek() == '/')){
                    calc();
                }
                --i;
            }
            else if(tmp  == '+' || tmp == '-'){
                calc();
                op.push(tmp);
            }else{
                op.push(tmp);
            }
        }
        
        calc();
        return num.peek();
        
    }
    
    private void calc(){
        if(!op.isEmpty()){
            char operator = op.pop();
            int b = num.pop();
            int a = num.pop();
            calc(a,b,operator);
        }
    }
    
    private void calc(int a, int b, char op){
        int result;
        if(op == '+'){
            result = a +b;
        }else if(op == '-'){
            result = a - b;
        }else if(op == '*'){
            result = a * b;
        }else{
            result = a/b;
        }
        num.push(result);
    }
}
