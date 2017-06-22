public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        // brute force 
        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length;i++){
            result[i] = -1;
            int j = i+1;
            while(j % nums.length != i){
                if(nums[j%nums.length] > nums[i]){
                    result[i] = nums[j%nums.length];
                    break;
                }
                j++;
            }
        }
        return result;
    }
}
