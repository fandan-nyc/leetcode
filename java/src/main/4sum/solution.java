public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 4){
            return result;
        }
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-3;i++){
            threeSum(nums, target-nums[i],i+1,result);
            while( i < nums.length-3 && nums[i] == nums[i+1]){
                i++;
            }
        }
        return result;
    }
    private List<List<Integer>> threeSum(int[] nums, int target, int startPoint,List<List<Integer>> result){
        // assume that, the nums are valid. 
         int low;
         int high;
         int sum;
         for(int i = startPoint; i < nums.length-2; i++){
             low = i+1;
             high = nums.length-1;
             while(low < high){
                 sum = nums[i]+ nums[low]+nums[high];
                 if(sum == target){
                    result.add(Arrays.asList(nums[startPoint -1], nums[i],nums[low],nums[high]));
                    while( low < high && nums[low]== nums[low+1]){
                        low++;
                    }
                    while(high > low && nums[high] == nums[high-1]){
                        high--;
                    }
                    low++;
                    high--;
                 }
                 else if(sum > target){
                     high--;
                 }
                 else {
                     low++;
                 }
                 while(i < nums.length-2 && nums[i]== nums[i+1])
                 {
                     i++;
                 }
             }
         }
         return result;
    }
}
