class Solution {
    public String removeKdigits(String num, int k) {
        if(k >= num.length()){
            return "0";
        }
        if(k == 0){
            return num;
        }
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < num.length(); i++){
            while(stack.isEmpty() == false && k > 0 && stack.peek() > num.charAt(i)){
                    stack.pop();
                    k--;
                }
                stack.push(num.charAt(i));
        }
        while(k > 0){
            stack.pop();
            k--;
        }
        StringBuilder result = new StringBuilder();
        while(stack.isEmpty() == false){
            result.insert(0, stack.pop());
        }
        while(result.length() > 1 && result.charAt(0) =='0'){
            result.deleteCharAt(0);
        }
        return result.toString();
    }
}
