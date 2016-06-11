public class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];
        for(int i = 1; i < nums.length; i++){
            int tmp = nums[i];
            int tmpMax = max;
            int tmpMin = min;
            max = Math.max(Math.max(tmpMax*tmp, tmpMin*tmp), tmp);
            min = Math.min(Math.min(tmpMin*tmp, tmpMax*tmp), tmp);
            res = Math.max(res, max);
        }
        return res;
    }
}
