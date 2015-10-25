public class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> romanStrMap = getRomanStrMap();
        int result  = 0; 
        if(s == null || s.length() == 0)
        {
            return result;
        }
        int tmp = 10000; 
        for(int i = 0; i < s.length(); i ++)
        {
            int curr = romanStrMap.get(s.charAt(i));
            result += (curr > tmp) ? ( - tmp*2 + curr):  curr;
            tmp = curr;
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
