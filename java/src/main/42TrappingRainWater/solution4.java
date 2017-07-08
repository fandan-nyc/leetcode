public class Solution {
    public int trap(int[] height) {
        if(height == null || height.length <= 2){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int sum  = 0; 
        int pos = 0; 
        while(pos < height.length){
            while(stack.empty() == false && height[pos] > height[stack.peek()]){
                int curr = stack.pop();
                if(stack.empty()){
                    break;
                }
                int dis = pos - stack.peek() -1 ;
                sum += (Math.min(height[pos], height[stack.peek()]) - height[curr]) * dis;
            }
            stack.push(pos);
            pos++;
        }
        return sum;
    }
    
}
