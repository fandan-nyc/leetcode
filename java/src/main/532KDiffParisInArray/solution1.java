public class Solution {
    public int findPairs(int[] nums, int k) {
        if(nums == null || nums.length <= 1 || k < 0){
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: nums){
            map.put(i, map.getOrDefault(i,0)+1);
        }
        int total = 0;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(k == 0){
                total += entry.getValue() >= 2 ?1:0;
            }else{
                total += map.containsKey(entry.getKey()+k) ? 1:0;
            }
        }
        return total;
    }
}
