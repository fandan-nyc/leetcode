public class Solution {
    public int trap(int[] height) {
        if(height == null || height.length <= 2){
            return 0;
        }
        int sum = 0;
        for(int i = 1; i < height.length-1; i++){
            sum += boundaryHeight(height, i);
        }
        return sum;
    }
    
    private int boundaryHeight(int[] height, int position){
        int curr = height[position];
        int left = position -1; 
        int right = position +1; 
        int leftHigh = curr; 
        int rightHigh = curr;
        while(left >= 0){
            if(height[left] > leftHigh){
                leftHigh =  height[left];
            }
            left--;
        }
        while(right < height.length){
            if(height[right] > rightHigh){
                rightHigh = height[right];
            }
            right ++;
        }
        int tmp = Math.min(leftHigh, rightHigh);
        return (tmp - curr);
    }
}
