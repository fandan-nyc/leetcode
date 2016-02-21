public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>(); 
        if(nums == null || nums.length == 0){
            return result ; 
        }
        for(int i = 0; i< nums.length; i++){
            int start = nums[i];
            int end = nums[i];
            while(i < nums.length-1 && nums[i] == nums[i+1] -1){
                end = nums[i+1];
                i++;
            }
            if(start == end){
                result.add(start+ "");
            }
            else{
                result.add(start + "->" + end);
            }
        }
        return result ; 
    }
}
