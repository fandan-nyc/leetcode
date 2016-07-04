public class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0 ){
            return 0;
        }else if(heights.length == 1){
            return heights[0];
        }
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for(int i = 0; i < heights.length; i++){
            if(stack.isEmpty() || heights[i] >= heights[stack.peek()]){
                stack.push(i);
            }else{
                while(stack.isEmpty() == false && heights[i] < heights[stack.peek()]){
                    int currBar = stack.pop();
                    int left = stack.isEmpty()? -1: stack.peek();
                    int right = i;
                    max = Math.max(max, (right - left -1) * heights[currBar]);
                }
                stack.push(i);
            }
        }
        while(stack.isEmpty() == false){
            int currBar = stack.pop();
            int left = stack.isEmpty()? -1: stack.peek();
            int right = heights.length;
            max = Math.max(max, (right - left -1) * heights[currBar]);
        }
        return max;
    }
}
