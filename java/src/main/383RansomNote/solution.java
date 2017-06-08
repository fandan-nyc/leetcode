public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] chars = new int[26];
        for(char i: magazine.toCharArray()){
            chars[i-'a'] ++;
        }
         for(char i: ransomNote.toCharArray()){
            chars[i-'a'] --;
        }
        for(int i : chars){
            if(i < 0){
                return false;
            }
        }
        return true;
    }
}
