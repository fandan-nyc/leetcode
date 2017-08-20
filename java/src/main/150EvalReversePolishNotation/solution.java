class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String i: tokens){
            if(!isOp(i)){
                stack.push(Integer.valueOf(i));
            }else{
                int b = stack.pop();
                int a = stack.pop();
                stack.push(calc(a, b, i));
            }
        }
        return stack.pop();
    }
    
    private boolean isOp(String i){
        return i.equals("+") || i.equals("-") || i.equals("*") || i.equals("/");
    }
    
    private int calc(int a, int b, String op){
        if(op.equals("+")){
            return a+b;
        }
        else if(op.equals("-")){
            return a-b;
        }else if(op.equals("*")){
            return a*b;
        }else{
            return a/b;
        }
    }   
}
