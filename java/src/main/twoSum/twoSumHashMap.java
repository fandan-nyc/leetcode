public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        if(nums == null || nums.length < 2)
            return null;
        for(int i = 0 ; i< nums.length ; i++){
            if(map.containsKey(nums[i]))
                return new int[]{map.get(nums[i]),i+1};
            else 
                map.put(target - nums[i], i+1);
        }
        return null;
    }
}
