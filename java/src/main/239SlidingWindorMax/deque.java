public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // deque
        if(nums == null || k == 0 || nums.length <= 0 || k > nums.length){
            return new int[0];
        }
        int[] result = new int[nums.length-k+1];
        Deque<Integer> dq = new LinkedList<Integer>(); 
        // prepare the deque for the first k elements 
        for(int i = 0; i < k; i++){
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.removeLast();
            }
            dq.addLast(i);
        }
        result[0] = nums[dq.peekFirst()];
        for(int i = k; i < nums.length; i++){
            while(!dq.isEmpty() &&dq.peekFirst() < i-k+1){
                dq.removeFirst();
            }
             while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.removeLast();
            }
            dq.addLast(i);
            result[i-k+1]=nums[dq.peekFirst()];
        }
        return result;
    }
}
