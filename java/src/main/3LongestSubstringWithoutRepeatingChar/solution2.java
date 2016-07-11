public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return  0;
        }
        int minPos = 0;
        int maxLen = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            // the char showed up before, and it showed up after the position where we start to count unique string
            // we update the start to be the next one. 
            if(map.containsKey(curr) && map.get(curr) >= minPos){
                minPos = map.get(curr)+1;
            }
            map.put(curr, i);
            maxLen = Math.max(maxLen, i-minPos+1);
        }
        return maxLen;
    }
}
