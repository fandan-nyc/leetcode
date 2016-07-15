public class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> romanMap = getRomanStrMap();
        int result = romanMap.get(s.charAt(0)); 
        for(int i = 1; i < s.length(); i++){
            int curr =  romanMap.get(s.charAt(i));
            int prev  = romanMap.get(s.charAt(i-1));
            result += curr;
            if(curr > prev){
                result -= prev *2;
            }
        }
        return result;
    }
    
    private Map<Character, Integer> getRomanStrMap()
    {
        Map<Character, Integer> romanIntMap = new HashMap<Character, Integer>();
             romanIntMap.put('I',1);
             romanIntMap.put('V',5);
             romanIntMap.put('X',10);
             romanIntMap.put('L',50);
             romanIntMap.put('C',100);
             romanIntMap.put('D',500);
             romanIntMap.put('M',1000);
      return romanIntMap;
    }
}
