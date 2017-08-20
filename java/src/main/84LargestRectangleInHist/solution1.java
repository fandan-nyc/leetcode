class Solution {
    int[][] dp;
    public int largestRectangleArea(int[] heights) {
        dp = new int[heights.length][heights.length];
        for(int[] i : dp){
            Arrays.fill(i,-1);
        }
        return helper(heights, 0, heights.length-1); 
    }
    
    private int helper(int[] heights, int start, int end){
        if(start <= end){
            if(dp[start][end] == -1){
                int min = min(heights, start, end);
                int total = heights[min] * (end - start+1);
                int res = Math.max(total, Math.max(helper(heights, start, min-1), helper(heights, min+1, end)));
                dp[start][end] = res;
            }
            return dp[start][end];
        }
        return 0;
    }
    
    public int min(int[] heights, int start, int end){
        int min = Integer.MAX_VALUE;
        int pos = -1;
        for(int i = start; i <= end; i++){
            if(min >= heights[i]){
                pos = i;
                min = heights[i];
            }
        }
        return pos;
    }
}
