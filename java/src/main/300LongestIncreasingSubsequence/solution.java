public class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length <= 0){
            return 0;
        }
        
        int[] dp = new int[nums.length];
        int counter = 0 ;
        dp[counter] = nums[0];
        for(int i = 1; i < nums.length; i ++){
            if(nums[i] >dp[counter]){
                dp[++counter] = nums[i];
            }else{
                int pos = binearySearch(dp, nums[i], counter);
                dp[pos] = nums[i];
            }
        }
        return counter +1;
    }
    
    private int binearySearch(int[] dp, int x, int end){
        int start = 0;
        while(start <= end){
            int middle = start + (end - start) /2;
            if(dp[middle]== x){
                return middle;
            }
            else if(dp[middle] < x){
                start = middle+1;
            }else{
                end = middle -1;
            }
        }
        return start;
    }
}
