public class Solution {
    public boolean isAnagram(String s, String t) {
        int[] result = new int[26];
        for(Character i: s.toCharArray())
        {
            result[i-'a'] += 1;
        }
        for(Character i : t.toCharArray())
        {
            result[i-'a'] -= 1;
        }
        for(int i: result)
        {
            if(i != 0)
            {
                return false;
            }
        }
        return true;
       
    }
}
