public class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> store = new HashMap<Integer, Integer>();
        for(int i: nums){
            store.put(i, store.containsKey(i)? (store.get(i)+1):1);
            if(store.get(i) > (nums.length / 2))
                return i;
        }
        return -1;
    }
}
