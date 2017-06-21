public class Solution {
    private int[] subSum;
    
    public int subarraySum(int[] nums, int k) {
        subSum = new int[nums.length];
        subSum[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            subSum[i] = subSum[i-1] + nums[i];
        }
        
        int counter = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = i; j < nums.length; j++){
                if(calcSubSum(i, j) == k){
                    counter++;
                }
            }
        }
        return counter;
    }
    
    private int calcSubSum(int start, int end){
        if(start == 0){
            return subSum[end];
        }else{
            return subSum[end] - subSum[start-1];
        }
    }
}
