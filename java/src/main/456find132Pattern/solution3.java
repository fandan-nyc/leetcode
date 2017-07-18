public class Solution {
    public boolean find132pattern(int[] nums) {
        int[] currMin = new int[nums.length];
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            min = Math.min(nums[i], min);
            currMin[i] = min;
        }
        Stack<Integer> stack = new Stack<>();
        for(int i = nums.length-1; i >= 0; i--){
            if(nums[i] > currMin[i]){
                while(!stack.isEmpty() && stack.peek() <= currMin[i]){
                    stack.pop();
                }
                if(!stack.isEmpty() && stack.peek() < nums[i]){
                    return true;
                }
                stack.push(nums[i]);
            }
        }
        return false;
    }
}
