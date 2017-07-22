public class Solution {
    public int longestPalindrome(String s) {
        // hashset
        int[] store = new int[58];
        for(char i: s.toCharArray()){
            store[i-'A']++;
            
        }
        int total = 0;
        for(int i: store){
            total += i/2*2;
        }
        return total + (total == s.length() ? 0: 1);
    }
}
