public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int count = 0;
        for(int i = 0; i < nums.length-2; i++){
            int start = i+1; 
            int end = nums.length -1;
            while(start < end){
                if(nums[i] + nums[start] + nums[end] >= target){
                    end--;
                }else{
                    count += ( end - start);
                    start ++;
                }
            }
        }
        return count;
    }
}

