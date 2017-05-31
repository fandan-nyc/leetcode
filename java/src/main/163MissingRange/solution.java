public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new LinkedList<>();
        if(nums == null || nums.length == 0 ){
            return result;
        }
        int n = nums.length;
        for(int i  = 0; i <= n; i++){
            int lt = (i ==0)? lower: nums[i-1]+1;
            int gt = (i ==n)? upper: nums[i]-1;
            addRange(result, lt, gt);
        }
        return result;
    }
    private void addRange(List<String> list, int low, int high){
        if(low > high){
            return;
        }
        else if ( low == high){
            list.add(String.valueOf(low));
        }else{
            list.add(low + "->" high);
        }
    }
}
