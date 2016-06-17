public class Solution {

    private Map<String, List<String>> map = new HashMap<String, List<String>>();
    private int min; 
    private int max;
    private Set<String> wordDict;
    public List<String> wordBreak( String s, Set<String> wordDict) {
        this.wordDict = wordDict;
        setMinMaxInDict();
        List<String> x = helper(s);
        return x;
    }
    
    private List<String> helper(String s){
        List<String> result = new ArrayList<String>();
        if(s == null || s.length() == 0){
            return result;
        }
        if(map.containsKey(s)){
            return map.get(s);
        }
        for(int i = min; i <= max && i <= s.length();i++){
            String subStr = s.substring(0,i);
            if(wordDict.contains(subStr)){
                List<String> rest = helper(s.substring(i));
                for(String t: rest){
                    result.add(subStr+ " " + t);
                }
                if(rest.isEmpty() && subStr.equals(s)){
                    result.add(subStr);
                }
            }
        }
        map.put(s, result);
        return result;
    }
    
    private void setMinMaxInDict(){
        int min = Integer.MAX_VALUE; 
        int max = 0;
        for(String i: wordDict){
            min = Math.min(min, i.length());
            max = Math.max(max, i.length());
        }
        this.min = min;
        this.max = max;
    }
}

