public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        if(nums == null || k > nums.length){
            return 0;
        }
        double avg = getFirstAvg(nums, k);
        double max = avg;
        for(int i = k; i < nums.length; i++){
            avg = (avg * k - nums[i-k] + nums[i])/k;
            max = Math.max(avg, max);
        }
        return max;
    }
    
    private double getFirstAvg(int[] data, int k){
        double currAvg = 0;
        for(int i = 0; i < k; i++){
            currAvg += data[i];
        }
        currAvg  /= k;
        return currAvg;
    }
}
