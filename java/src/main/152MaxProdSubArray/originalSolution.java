public class Solution {
    public int maxProduct(int[] nums) {
        int[] maxProd = new int[nums.length];
        int[] minProd = new int[nums.length];
        maxProd[0] = minProd[0] = nums[0];
        int max = nums[0];
        for(int i = 1; i < nums.length; i++){
            int tmp = nums[i];
            maxProd[i] = Math.max(tmp, Math.max(tmp*maxProd[i-1], tmp*minProd[i-1]));
            minProd[i] = Math.min(tmp, Math.min(tmp*maxProd[i-1],tmp*minProd[i-1]));
            max = Math.max(maxProd[i], max);
        }
        return max;
    }
}
