public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); 
        for(int i = 0; i < nums.length; i ++){
            if(map.containsKey(nums[i]) && map.get(nums[i]) + k >= i){
                return true;
            }
            map.put(nums[i],i);
        }
        return false;
    }
}
