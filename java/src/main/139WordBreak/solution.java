public class Solution {
    private int min = Integer.MAX_VALUE; 
    private int max = 0;
    private Set<String> wordDict;
    private Map<String, Boolean> map = new HashMap<String, Boolean>();
    public boolean wordBreak(String s, Set<String> wordDict) {
      if(s == null || wordDict == null || wordDict.isEmpty() || s.length() == 0){
          return false;
      }
      this.wordDict = wordDict;
      for(String i: wordDict){
            int len = i.length();
            max = max > len ? max: len;
            min = min < len ? min: len;
      }
      return helper(s);
    }
    
    private boolean helper(String s){
        if(map.containsKey(s)){
            return map.get(s);
        }
        if(s.length() == 0){
            return true;
        } else if(s.length() < min){
            return false;
        }
        boolean result  = false;
        for(int i = min; i <= max && i <= s.length();i++){
            if(wordDict.contains(s.substring(0,i))){
                boolean tmp  = helper(s.substring(i));
                map.put(s.substring(i), tmp);
                result = result || tmp;
            }
        }
        return result;
    }
}
