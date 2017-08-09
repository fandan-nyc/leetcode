public class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>();
        for(int i: nums){
            pq.add(i);
        }
        int counter = 0;
        int res = 0;
        while(counter < nums.length - k +1){
            res = pq.remove();
            counter++;
        }
        return res ; 
    }
}
