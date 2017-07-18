public class Solution {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        int[] result = new int[findNums.length];
        Map<Integer, Integer> store = new HashMap<Integer, Integer>();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < nums.length; i++){
            while(stack.isEmpty() == false && nums[i] > stack.peek()){
                store.put(stack.pop(), nums[i]);
            }
            stack.push(nums[i]);
        }
        while(!stack.isEmpty()){
            store.put(stack.pop(), -1);
        }
        for(int i = 0; i < findNums.length; i ++){
            result[i] = store.get(findNums[i]);
        }
        return result;
    }
    
}
