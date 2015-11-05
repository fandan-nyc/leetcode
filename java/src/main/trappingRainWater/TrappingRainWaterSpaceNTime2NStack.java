public class Solution {
    public int trap(int[] height) {
       Stack<Integer> stack = new Stack<Integer>(); 
       int leftHigh = 0;
       int result = 0;
       for(int i = 0; i < height.length; i ++)
       {
           if(height[i] >= leftHigh)
           {
               while(!stack.isEmpty())
               {
                   result += leftHigh - stack.pop();
               }
               stack.push(height[i]);
               leftHigh = height[i];
           }
           else
           {
               stack.push(height[i]);
           }
       }
       int rightHigh  =  0;
       while(!stack.isEmpty())
       {
           int curr = stack.pop();
           rightHigh = Math.max(curr, rightHigh);
           result +=   rightHigh - curr;
       }
       return result ;
    }
}
