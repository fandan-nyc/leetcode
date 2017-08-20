class Solution {
    int[][] dp;
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> pos = new Stack<>();
        pos.push(-1);
        int total = 0;
        for(int i = 0; i < heights.length; i++){
            if(pos.peek() == -1 || heights[i] > heights[pos.peek()]){
                pos.push(i);
            }else{
                while(pos.peek() != -1 && heights[i]< heights[pos.peek()]){
                    int currPos = pos.pop();
                    total = Math.max(total, heights[currPos] * (i - pos.peek()-1));
                }
                pos.push(i);
            }
        }
        while(pos.peek() != -1){
            int curr = pos.pop();
            total = Math.max(total, heights[curr] * (heights.length - pos.peek()-1));
        }
        return total;
    }

}
