class Solution {
    public int splitArray(int[] nums, int m) {
        long max = Integer.MIN_VALUE;
        long sum = 0;
        for(int i: nums){
            max = Math.max(i, max);
            sum += i;
        }
        long left = max;
        long right = sum;
        while(left <= right){
            long middle = (left+ right)/2;
            if(!valid(nums, middle, m)){
                left = middle+1;
            }else{
                right = middle-1;
            }
        }
        return (int)left;
    }
    
    private boolean valid(int[] nums, long target, int targetCount){
        long total = 0;
        int counter = 1;
        for(int i = 0; i < nums.length; i++){
            total += nums[i];
            if(total > target){
                counter++;
                total = nums[i];
            }
            if(counter > targetCount){
                return false;
            }
        }
        return true;
    }
    // binary search
}
