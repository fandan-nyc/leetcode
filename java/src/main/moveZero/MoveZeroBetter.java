public class Solution {
    public void moveZeroes(int[] nums) {
        int count = 0;
        int next  = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                swap(nums, i, next);
                next++;
            }
        }
    }
    
    private void swap(int[] data, int a, int b){
        int tmp =  data[a];
        data[a] = data[b] ;
        data[b] = tmp;
    }
}
