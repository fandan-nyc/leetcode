public class Solution {
    public int trap(int[] height) {
        if(height == null || height.length <= 2){
            return 0;
        }
      // two pointers 
        int leftMax = 0; 
        int rightMax = 0;
        int left = 0; 
        int right = height.length-1;
        int sum = 0; 
        while(left < right){
            if(height[left] < height[right]){
                leftMax = Math.max(height[left], leftMax); 
                sum += Math.max(0,leftMax - height[left]);
                ++left;
            }else{
                rightMax = Math.max(height[right], rightMax); 
                sum += Math.max(0,rightMax - height[right]);
                --right;
            }
        }
        return sum;
        
    }
    
}
