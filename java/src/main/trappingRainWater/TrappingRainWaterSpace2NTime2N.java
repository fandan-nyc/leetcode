public class Solution {
    public int trap(int[] height) {
        int[] rightHighest = new int[height.length];
        int[] leftHighest = new int[height.length];
        int leftTmp = 0; 
        int rightTmp = 0;
        for(int i = 0; i < height.length; i++)
        {
            leftTmp = Math.max(height[i], leftTmp);
            leftHighest[i] = leftTmp;
        }
        for(int i = height.length -1; i >= 0; i--)
        {
            rightTmp = Math.max(height[i], rightTmp);
            rightHighest[i] = rightTmp;
        }
        int result  =0 ;
        for(int i = 0; i < height.length; i++)
        {
            int diff = Math.min(leftHighest[i], rightHighest[i]) - height[i];
            result += (diff > 0) ? diff: 0;
         }
         return result ; 
     
    }
}
