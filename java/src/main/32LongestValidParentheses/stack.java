public class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int left = -1;
        int max= 0 ; 
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }else if(!stack.isEmpty()){
                stack.pop();
                max = Math.max(max, i - (stack.isEmpty() ? left: stack.peek()));
            }else {
                left = i;
            }
        }
        return max ;
    }
}
