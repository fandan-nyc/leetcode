public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0; 
        int end = numbers.length-1;
        while(start < end){
            int curr = numbers[start] + numbers[end];
            if(curr > target){
                end--;
            }else if(curr == target){
                return new int[]{start+1, end+1};
            }else{
                start ++;
            }
        }
        return new int[]{-1,-1};
    }
}
