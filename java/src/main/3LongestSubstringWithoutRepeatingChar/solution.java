public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() <= 0){
            return 0;
        }else if(s.length() == 1){
            return 1;
        }
        int[] store = new int[256];
        int left =0 ;
        int max = 1; 
        for(int right = 0; right < s.length(); right++){
            char rightChar = s.charAt(right);
            if(store[rightChar] == 0){
                store[rightChar] = 1;
            }else{
                while(left <= right && store[rightChar] == 1){
                    store[s.charAt(left)] -=1;
                    left++;
                }
                store[rightChar] = 1;
            }
            max = max > (right - left +1) ? max: (right - left +1);
        }
        return max;
    }
}
