public class Solution {
    public int maximumGap(int[] nums) {
        if(nums == null || nums.length < 2){
            return 0;
        }
        int min = nums[0];
        int max = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < min){
                min = nums[i];
            }
            else if(nums[i] > max){
                max = nums[i];
            }
        }
        if(max == min){
            return 0;
        }
        if(nums.length == 2){
            return max - min;
        }
        final  int gap = (max - min) / (nums.length-1) +1;
        assert gap > 0 ;
        int[][] bucket = new int[nums.length][2];
        for(int i = 0; i < nums.length;i++){
            bucket[i][0] = -1;
            bucket[i][1] = -1;
        }
        for(int i = 0; i < nums.length;i++){
            int tmp = nums[i];
            int pos = (tmp-min)/gap;
            if(bucket[pos][0] == -1){
                bucket[pos][0]= tmp;
            }
            bucket[pos][0] = (bucket[pos][0] < tmp) ? bucket[pos][0] : tmp;
            bucket[pos][1] = (bucket[pos][1] > tmp) ? bucket[pos][1] : tmp;
        }
        int result  = 0;
        int currMin = bucket[0][0];
        int currMax = bucket[0][1];
        for(int i = 1; i < nums.length;i++){
            if(bucket[i][0] == -1){
                continue;
            }
            else{
                int tmp = bucket[i][0]- currMax;
                result = result > tmp? result: tmp;
                currMax = bucket[i][1];
            }
        }
        return result;
    }
}
