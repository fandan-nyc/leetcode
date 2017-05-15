public class Solution {
    Map<Character, Character> stroboMap = new HashMap<Character, Character>(){{
        put('8','8');
        put('0','0');
        put('1','1');
        put('6','9');
        put('9','6');

    }};
    public boolean isStrobogrammatic(String num) {
        int start = 0; 
        int end = num.length()-1;
        while(start <= end){
            char startChar = num.charAt(start);
            char endChar = num.charAt(end);
            if(stroboMap.containsKey(startChar) == false || stroboMap.get(startChar) != endChar){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
