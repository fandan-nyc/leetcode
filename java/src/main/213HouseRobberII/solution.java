public class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }else if(nums.length == 1){
            return nums[0];
        }
        int first = rob(nums, 1,nums.length-1);
        int second = rob(nums, 0, nums.length-2);
        return first > second ? first: second;
    }
    
    private int rob(int[] nums, int start, int end) {
        if(nums == null || nums.length ==  0|| start > end){
            return 0;
        }
        int i_1 = 0;
        int i_2 = 0;
        int max = 0 ;
        for(int i = start; i <= end;i++){
            max = Math.max(i_2 + nums[i],i_1);
            i_2=i_1;
            i_1=max;
        }
        return max;
    }
}
