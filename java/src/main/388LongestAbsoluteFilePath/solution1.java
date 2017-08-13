public class Solution {
    public int lengthLongestPath(String input) {
        if(input == null || input.length() == 0){
            return 0;
        }
        String[] inputs = input.split("\n");
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int currentLevel = 0;
        int maxLen = 0;
        for(String i: inputs){
            int level = getLevel(i);
            while(level + 1 < stack.size()){
                stack.pop();
            }
            stack.push(stack.peek()+ i.length() - level +1);
            if(isFile(i)){
                maxLen = Math.max(maxLen, stack.peek()-1);
            }
        }
        return maxLen;
        
    }
        
    private boolean isFile(String input){
        return input.indexOf(".") != -1;
    }
    
    private int getLevel(String input){
        int level = 0;
        for(char i: input.toCharArray()){
            if(i =='\t'){
                level++;
            }else{
                break;
            }
        }
        return level;
    }
}
