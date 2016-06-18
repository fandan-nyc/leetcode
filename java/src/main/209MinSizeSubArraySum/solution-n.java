class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0; 
        int min = Integer.MAX_VALUE;
        int start = 0 ;
        int end  = 0 ;
        for(int i = 0; i < nums.length;i++){
            sum += nums[i];
            end++;
            if(sum >= s){
                while(sum >= s){
                    sum -= nums[start];
                    start++;
                }
                min = (min < end-start+1) ? min: (end-start+1);
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min ;
    }
}
