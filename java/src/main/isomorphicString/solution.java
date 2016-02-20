public class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<Character, Character>(); 
        Set<Character> set = new HashSet<Character>(); 
        for(int i = 0; i < s.length(); i ++){
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if(map.containsKey(sChar)){
                if(tChar != map.get(sChar)){
                    return false;
                }
            }
            else{
                map.put(sChar, tChar);
                if(!set.add(tChar)){
                    return false;
                }
            }
        }
        return true;
    }
}
