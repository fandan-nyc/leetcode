public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new LinkedList<>();
        if(nums == null){
            return result;
        }
        int n = nums.length;
        for(int i  = 0; i <= n; i++){
            long lt = (i ==0)? lower: (long)nums[i-1]+1;
            long gt = (i ==n)? upper: (long)nums[i]-1;
            addRange(result, lt, gt);
        }
        return result;
    }
    private void addRange(List<String> list, long low, long high){
        if(low > high){
            return;
        }
        else if ( low == high){
            list.add(String.valueOf(low));
        }else{
            list.add(low + "->" + high);
        }
    }
}
