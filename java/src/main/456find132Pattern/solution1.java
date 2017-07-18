public class Solution {
    public boolean find132pattern(int[] nums) {
        for(int i = 0; i < nums.length-2; i++){
            for(int j = i+1; j < nums.length-1;j++){
                for(int k = j+1; k < nums.length; k++){
                    if(is132Pattern(nums[i],nums[j],nums[k])){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private boolean is132Pattern(int a, int b, int c){
        return a < b && b > c && a < c;
    }
}
