public class Solution {
    public int maxArea(int[] height) {
        int result = 0;
        int start = 0;
        int end  = height.length -1 ; 
        while(start < end)
        {
            result = Math.max(result, Math.min(height[start], height[end]) * (end - start));
            if(height[start] < height[end])
            {
                start ++;
            }
            else
            {
                end --;
            }
        }
        return result ;
    }
}
