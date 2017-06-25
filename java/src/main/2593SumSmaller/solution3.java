public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int count = 0;
        for(int i = 0; i < nums.length-2; i++){
            for(int j = i+1; j < nums.length-1; j++){
                count += binarySearch(nums, target - nums[i] - nums[j], j) - j;
            }
        }
        return count;
    }
    
    private int binarySearch(int[] nums, int target, int start){
        int end = nums.length-1;
        while(start < end){
            int mid = ( start + end + 1) /2;
            if(nums[mid] < target){
                start = mid;
            }else{
                end = mid-1;
            }
        }
        return start;
    }
}

