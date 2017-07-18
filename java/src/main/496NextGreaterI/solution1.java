public class Solution {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        int[] result = new int[findNums.length];
        for(int i = 0; i < findNums.length; i++){
            int curr = findNums[i];
            result[i] = -1;
            boolean find = false;
            for(int j = 0; j < nums.length; j++){
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
