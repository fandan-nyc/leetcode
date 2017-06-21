public class Solution {

    public int subarraySum(int[] nums, int k) {
        int counter = 0;
        Map<Integer, Integer> store = new HashMap<>();
        store.put(0, 1);
        int sum = 0 ;
        for(int i: nums){
            sum += i;
            if(store.containsKey(sum-k)){
                counter += store.get(sum-k);
            }
            store.put(sum, store.getOrDefault(sum,0) +1);
        }
        return counter;
    }
}
