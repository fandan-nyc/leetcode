public class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0){
            return true;
        }
        Stack<Character> stack = new Stack<Character>();
        for(char i: s.toCharArray()){
            if(i == '(' || i == '[' || i == '{'){
                stack.push(i);
            }else{
                if(stack.isEmpty() || (stack.peek() +1 != i && stack.peek()+2 != i)){
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
