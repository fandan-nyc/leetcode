public class Solution {
    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        int[] letters = new int[26];
        for (int i = 0; i < chars.length; i ++) {
            letters[chars[i] - 'a'] ++;
        }
        for (int i = 0; i < chars.length; i ++) {
            if (letters[chars[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
