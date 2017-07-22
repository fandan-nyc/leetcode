public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] min = new int[nums.length];
        int[] max = new int[nums.length];
        min[nums.length-1] = nums[nums.length-1];
        max[0] = nums[0];
        for(int i = nums.length-2; i >= 0 ; i--){
            min[i]= Math.min(min[i+1], nums[i]);
        }
        for(int i = 1; i < nums.length ; i++){
            max[i]= Math.max(max[i-1], nums[i]);
        }
        int rangeMin = nums.length;
        int rangeMax = -1;
        int i = 0 ;
        while( i < nums.length){
            if(!(nums[i] == min[i] && nums[i] == max[i])){
                rangeMin = Math.min(rangeMin, i);
                rangeMax = Math.max(rangeMax, i);
            }
            i++;
        }
        return rangeMin == nums.length ? 0: (rangeMax - rangeMin +1);
    }
}
