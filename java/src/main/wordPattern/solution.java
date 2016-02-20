public class Solution {
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> map = new HashMap<Character, String>();
        Map<String, Character> map2 = new HashMap<String, Character>(); 
        String[] strArr = str.split(" ");
        if(pattern.length() != strArr.length){
            return false;
        }
        for( int i = 0; i < strArr.length; i ++){
            if(map.containsKey(pattern.charAt(i)) && !map.get(pattern.charAt(i)).equals(strArr[i])){
                return false;
            }
            if(map2.containsKey(strArr[i]) && !map2.get(strArr[i]).equals(pattern.charAt(i))){
                return false;
            }
            map.put(pattern.charAt(i), strArr[i]);
            map2.put(strArr[i],pattern.charAt(i));
        }
        return true;
    }
}
