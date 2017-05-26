public class Solution {
    public boolean canPermutePalindrome(String s) {
        Set<Character> palindrome = new HashSet<Character>();
        for(int i =0; i < s.length(); i++){
            char curr = s.charAt(i);
            if(palindrome.contains(curr)){
                palindrome.remove(curr);
            }else{
                palindrome.add(curr);
            }
        }
        return palindrome.size() <= 1;
    }
}
