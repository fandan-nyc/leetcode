public class Solution {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        int[] result = new int[findNums.length];
        Map<Integer, Integer> store = new HashMap<Integer, Integer>();
        for(int i = 0; i < findNums.length; i++){
            int curr = findNums[i];
            result[i] = -1;
            boolean find = false;
            int start = store.getOrDefault(curr, 0);
            for(int j = start; j < nums.length; j++){
                store.put( nums[j],j);
                if(nums[j] == curr){
                    find = true;
                }else if(find && nums[j] > curr){
                    result[i] = nums[j];
                    break;
                }
            }
        }
        return result;
    }
}
