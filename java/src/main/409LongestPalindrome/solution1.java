public class Solution {
    public int longestPalindrome(String s) {
        // hashset
        Set<Character> set = new HashSet<>();
        int counter = 0;
        for(char i: s.toCharArray()){
            if(set.add(i) == false){
                set.remove(i);
                counter += 2;
            }
        }
        return counter + (set.size() > 0 ? 1: 0);
    }
}
