public class Solution {
    public int minPatches(int[] nums, int n) {
        int added = 0;
        long reach = 0;
        for(int i : nums){
            if(reach >= n){
                return added;
            }
            while(reach < i-1 && reach < n){
                added += 1;
                reach = reach *2+1;
            }
            reach += i;
        }
        while(reach < n){
            added +=1;
            reach = reach *2 +1;
        }
        return added;
    }
}
