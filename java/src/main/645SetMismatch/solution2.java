class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        for(int i = 0; i < nums.length; i++){
            int curr = nums[i];
            if(nums[Math.abs(curr)-1] < 0){
                res[0] = Math.abs(curr);
            }
            if(nums[Math.abs(curr)-1] > 0){
                nums[Math.abs(curr)-1] =  -1 * nums[Math.abs(curr)-1];
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                res[1] = i+1;
                break;
            }
        }
        return res ;

    }
}
