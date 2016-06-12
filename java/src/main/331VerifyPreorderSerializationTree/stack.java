public class Solution {
    public boolean isValidSerialization(String preorder) {
        if(preorder == null){
            return false;
        }
        String[] input = preorder.split(",");
        Stack<String> stack = new Stack<>();
        for(String i: input){
            if(i.equals("#")){
                    while(!stack.isEmpty() && stack.peek().equals("#")){
                        stack.pop();
                        if(stack.isEmpty()){
                            return false;
                        }
                        stack.pop();
                    }
                    stack.push(i);
            }else{
                stack.push(i);
            }
        }
        return stack.size() == 1 && stack.peek().equals("#");
    }
}
