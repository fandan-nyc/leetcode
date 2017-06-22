public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        // brute force 
        int[] result = new int[nums.length];
        int[] newNum = new int[nums.length*2];
        for(int i = 0; i < nums.length; i++){
            newNum[i] = nums[i];
            newNum[i+nums.length] = nums[i];
        }
        for(int i = 0; i < nums.length;i++){
            result[i] = -1;
            for(int j = i +1; j < i + nums.length; j++){
                if(newNum[j] > nums[i]){
                    result[i] = newNum[j];
                    break;
                }
            }
        }
        return result;
    }
}
