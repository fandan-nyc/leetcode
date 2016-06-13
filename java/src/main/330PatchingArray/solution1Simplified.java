public class Solution {
    public int minPatches(int[] nums, int n) {
        int added = 0;
        long reach = 0;
        int i = 0;
        while(reach < n){
            if(i >= nums.length || reach < nums[i]-1){
                added += 1;
                reach = reach * 2 +1;
            }else {
                reach += nums[i++];
            }
        }
        return added ; 
    }
}
