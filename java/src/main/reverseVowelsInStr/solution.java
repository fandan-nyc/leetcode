public class Solution {
    private final List<Character> vowels = Arrays.asList('a','e','i','o','u','A','E','I','O','U');
    
    public String reverseVowels(String s) {
        char[] result = s.toCharArray();
        int start = 0; 
        int end = s.length() -1; 
        while(start < end){
            while(start < s.length() && isVowel(s.charAt(start)) == false){
                start++;
            }
            while(end >= 0 && isVowel(s.charAt(end)) == false){
                end--;
            }
            if(start < end){
                result[start] = s.charAt(end);
                result[end] = s.charAt(start);
                start++;
                end--;
            }
        }
        return new String(result);
    }
    
    private boolean isVowel(char i){
        return vowels.contains(i);
    }
}
