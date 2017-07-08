public class Solution {
    public int trap(int[] height) {
        if(height == null || height.length <= 2){
            return 0;
        }
        // get the highest to the left
        int[] left = new int[height.length];
        left[0] =  height[0];
        for(int i = 1; i < height.length; i++){
            left[i] = height[i] > left[i-1] ? height[i]: left[i-1];
        }
        // get the highest to the right
        int[] right = new int[height.length];
        right[height.length-1] =  height[height.length-1];
         for(int i = height.length-2; i >= 0; i--){
            right[i] = height[i] > right[i+1] ? height[i]: right[i+1];
        }
        int sum = 0;
        for(int i = 1; i < height.length-1; i++){
            int leftHigh = left[i-1];
            int rightHigh= right[i+1];
            int tmp = Math.min(leftHigh, rightHigh);
            sum += (tmp - height[i]) > 0 ? (tmp - height[i]): 0;
        }
        return sum;
    }
    
}
