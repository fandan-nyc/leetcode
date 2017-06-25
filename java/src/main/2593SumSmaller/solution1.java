public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int counter = 0;
        for(int i = 0; i < nums.length-2; i++){
            for(int j = i+1; j < nums.length-1; j++){
                for(int k = j+1; k < nums.length; k++){
                    if(nums[i] + nums[j] + nums[k] <target){
                        counter++;
                    }
                }
            }
        }
        return counter;
    }
}

