public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        // brute force 
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];
        for(int i= nums.length *2 -1; i >= 0; i--){
            while(!stack.isEmpty() && nums[stack.peek()] <= nums[i%nums.length]){
                stack.pop();
            }
            if(stack.isEmpty()){
                result[i%nums.length] = -1;
            }else{
                result[i%nums.length] = nums[stack.peek()];
            }
            stack.push(i%nums.length);
        }
        return result;
    }
}
