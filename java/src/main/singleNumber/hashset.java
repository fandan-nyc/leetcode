public class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> result = new HashSet<Integer>();
        for(int i: nums){
            if(result.contains(i)){
                result.remove(i);
            }else{
                result.add(i);
            }
        }
        assert result.size() == 1;
        return result.iterator().next();
    }
}
// another way
 class Solution1 {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> store = new HashMap<Integer, Integer>();
        for (int j = 0; j < nums.length; j ++){
            int i = nums[j];
            if(store.containsKey(i)){
                store.put(i, store.get(i)+1);
            }
            else{
                store.put(i,1);
            }
        }
        for(Integer i: store.keySet()){
            if(store.get(i) == 1){
                return i;
            }
        }
        return -1;
    }
}
