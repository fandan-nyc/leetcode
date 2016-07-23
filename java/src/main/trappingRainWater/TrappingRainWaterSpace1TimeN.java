public class Solution {
    public int trap(int[] height) {
       int result = 0; 
       int left = 0;
       int right = height.length -1 ;
       int tmpMax = 0; 
       while(left < right)
       {
           if(height[left] < height[right])
           {
               tmpMax = Math.max(height[left], tmpMax);
               result +=  tmpMax - height[left];
               left ++;
           }
           else
           {
             tmpMax =  Math.max(height[right], tmpMax);
             result += tmpMax - height[right];
             right--;
           }
       }
       return result ; 
    }
}
