public class Solution {
    // the idea is that, if the nums is in desc order, then we reverse
    // otherwise, we find longest descending string in the tail. for example, 123987, the longest desc string in the tail is 987. 
    // then we know we should swap 3 with the number in the tail which is the smallest among all the numbers larger than 3. 
    // then we reverse
    // https://discuss.leetcode.com/topic/2542/share-my-o-n-time-solution
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length <=1){
            return;
        }
        int firstPos = -1;
        for(int i = nums.length-1; i > 0; i--){
            if(nums[i-1] < nums[i]){
                firstPos = i-1;
                break;
            }
        }
        if(firstPos == -1){
            reverse(nums, 0, nums.length-1);
            return;
        }
        int toSwapPos = nums.length-1 ;
        for(int i = nums.length-1; i >= 0; i--){
            if(nums[i] > nums[firstPos]){
                toSwapPos = i;
                break;
            }
        }
        swap(nums, firstPos, toSwapPos);
        reverse(nums, firstPos+1, nums.length-1);
        return;
    }
    
    private void reverse(int[] nums, int start, int end){
        if(start >= end){
            return;
        }
        while(start < end){
            swap(nums, start, end);
            start ++;
            end --;
        }
        return;
    }
    
    private void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
