public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        if(s == null || s.length() == 0)
            return max;
        Map<Character,Integer> map = new HashMap<Character, Integer>();
        int tmp =0;
        int start = 0;
        for(int i = 0; i < s.length(); i ++){
            char x = s.charAt(i);
            if(map.containsKey(x) && map.get(x) >= start){
                    max = Math.max(max, tmp);
                    start = map.get(x) +1;
                    tmp = i - start;
                }
            tmp++;
            map.put(x,i);
        }
        return Math.max(max, tmp);
    }
}

