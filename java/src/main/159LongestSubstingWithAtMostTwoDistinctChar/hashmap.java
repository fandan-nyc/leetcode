public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> distChar = new HashMap<>();
        int max = 0;
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            char current = s.charAt(i);
            if(distChar.size() <= 2){
                distChar.put(current, i);
                count++;
            }
            if(distChar.size() > 2) {
                char toKickOut = 0;
                int pos = s.length();
                for(int t : distChar.values()){
                    if(t < pos){
                        pos = t;
                    }
                }
                distChar.remove(s.charAt(pos));
                count = i - pos ;
            }
            max = max > count ? max: count;
        }
        return  max ;
    }
}
