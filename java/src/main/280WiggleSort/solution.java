public class Solution {
    public void wiggleSort(int[] nums) {
        for(int i = 0; i < nums.length;i++){
            if(i%2 == 1){
                if(nums[i] < nums[i-1]){
                    swap(nums, i,i-1);
                }
            }else if( i != 0 && nums[i] > nums[i-1]){
                swap(nums, i, i-1);
            }
                
        }
    }
    
    private void swap(int[] data, int a, int b){
        int tmp = data[a];
        data[a] = data[b];
        data[b] = tmp;
    }
}
