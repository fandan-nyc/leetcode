public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null  || matrix.length == 0  || matrix[0].length == 0){
            return 0;
        }
        int[][] height = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length;j++){
                if(matrix[i][j] == '0'){
                    height[i][j] = 0;
                }else{
                    height[i][j] = ((i == 0)? 0 : height[i-1][j]) + 1;
                }
            }
        }
        int max = 0; 
        for(int i = 0; i < matrix.length; i ++){
            max = Math.max(max, maxRectangleInHist(height[i]));
        }
        return max;
    }
    
    private int maxRectangleInHist(int[] hist){
        if(hist == null || hist.length == 0){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int max = 0;
        while(i < hist.length){
            if(stack.isEmpty() || hist[i] >= hist[stack.peek()]){
                stack.push(i++);
            }else{
                int currBar = stack.pop();
                max = Math.max(max, hist[currBar] * (i - (stack.isEmpty() ? -1 : stack.peek()) -1));
            }
        }
        while(!stack.isEmpty()){
            int currBar = stack.pop(); 
            max = Math.max(max, hist[currBar] * ( hist.length - (stack.isEmpty() ? -1 : stack.peek()) -1));
        }
        return max;
    }
}
