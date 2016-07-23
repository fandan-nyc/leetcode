public class Solution {
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        int n= nums.length;
        while(i < nums.length){
            if(nums[i] >= 0 && nums[i] < n && nums[i] != nums[nums[i]]){
                swap(nums, i, nums[i]);
            }
            else{
                i++;
            }
        }
        int k = 1;
        while (k < n && nums[k] == k){
		    k++;
        }

         // If it breaks because of empty array or reaching the end. K must be the first missing number.
	    if (n == 0 || k < n)
		    return k;
	    else   // If k is hiding at position 0, K+1 is the number. 
		    return nums[0] == k ? k + 1 : k;
    }
    
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
