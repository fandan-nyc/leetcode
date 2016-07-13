public class Solution {
    public int singleNumber(int[] nums) {
        int one = 0; 
        int two = 0; 
        int three ; 
        for(int i: nums){
//https://discuss.leetcode.com/topic/2926/accepted-code-with-proper-explaination-does-anyone-have-a-better-idea           
            two |=(one & i);
            one ^= i;
            three = ~ (one & two);
            one &= three;
            two &= three;
        }
        return one;
    }
}
