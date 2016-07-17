public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums ==  null || nums.length == 0){
            return 0;
        }
        if(nums.length <=3){
            int result = 0 ;
            for(int i = 0;  i < nums.length; i++){
                result += nums[i];
            }
            return result;
        }
        Arrays.sort(nums);
        int large = Integer.MAX_VALUE;
        int small = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length-2; i++){
            int start  = i+1;
            int end = nums.length-1;
            while(start < end){
                int curr = nums[i] + nums[start] + nums[end];
                if(curr == target){
                    return target;
                }else if(curr > target){
                    large = Math.min(large, curr-target);
                    end--;
                }else if(curr < target){
                    small = Math.max(small, curr-target);
                    start++;
                }
            }
        }
        return target + ((large+ small ) > 0 ? small : large);
    }
}
