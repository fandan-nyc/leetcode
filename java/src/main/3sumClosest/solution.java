public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        if(nums == null || nums.length <3)
            return 0;
        int tmpPos = Integer.MAX_VALUE;
        int tmpNeg = Integer.MIN_VALUE+1;
        int low;
        int high;
        int sum;
        for(int i = 0; i < nums.length -2;i++){
            low = i+1;
            high = nums.length -1;
            while(low < high){
                sum = nums[i] + nums[low] + nums[high];
                if(sum == target)
                    return target;
                else if(sum < target){
                    tmpNeg = Math.max(tmpNeg,sum - target);
                    while( low < high && nums[low] == nums[low+1]){
                        low++;
                    }
                    low++;
                }
                else{
                    tmpPos = Math.min(tmpPos, sum - target);
                    while( low < high && nums[high] == nums[high-1]){
                        high--;
                    }
                    high--;
                }
            
            while(i < nums.length-2 && nums[i] == nums[i+1])
            {
                i++;
            }
        }}
        return  target+ ((Math.abs(tmpPos) > Math.abs(tmpNeg))? tmpNeg : tmpPos);
    }
}
