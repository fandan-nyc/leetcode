public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // with space
        for(int i = 0; i < nums.length; i++){
            int curr = nums[i];
            if(curr != -1 && nums[curr-1] != -1){
                swap(nums, i, curr-1);
                nums[curr-1] = -1;
                i--;
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < nums.length;i++){
            if(nums[i] != -1){
                res.add(i+1);
            }
        }
        return res;
    }
    
    private void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
