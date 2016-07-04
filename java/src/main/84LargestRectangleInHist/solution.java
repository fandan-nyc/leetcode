public class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0 ){
            return 0;
        }
        int[] lessFromLeft  = new int[heights.length];
        lessFromLeft[0] = -1;
        for(int i = 1; i < heights.length; i++){
            if(heights[i-1] < heights[i]){
                lessFromLeft[i] = i-1;
            }
            else{
                int p = lessFromLeft[i-1];
                while(p >= 0 && heights[p] >= heights[i]){
                    p = lessFromLeft[p];
                }
                lessFromLeft[i] = p;
            }
        }
        int[] lessFromRight = new int[heights.length];
        lessFromRight[heights.length-1] = heights.length;
        for(int i = heights.length-2; i >= 0; i--){
            if(heights[i+1] < heights[i]){
                lessFromRight[i] = i+1;
            }
            else{
                int p = lessFromRight[i+1];
                while(p < heights.length && heights[p] >= heights[i]){
                    p = lessFromRight[p];
                }
                lessFromRight[i] = p;
            }
        }
        int max = 0; 
        for(int i = 0; i < heights.length; i++){
            int curr = heights[i] * (lessFromRight[i]-lessFromLeft[i]-1);
            max = max > curr ? max: curr;
        }
        return max;
    }
}
