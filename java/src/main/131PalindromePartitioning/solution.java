public class Solution {
    private Map<String, Boolean> map = new HashMap<String,Boolean>();
    
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        if(s == null || s.length() == 0){
            result.add(new ArrayList<String>());
            return result;
        };
        helper(result, s, new ArrayList<String>());
        return result;
    }
    
    public void helper(List<List<String>> result, String s, List<String> tmp){
        if(s == null || s.length() == 0 ){
            result.add(new ArrayList<String>(tmp));
            return;
        }
        for(int i = 0; i < s.length(); i++){
            String tmpStr = s.substring(0,i+1);
            if(isPalindrome(tmpStr)){
                tmp.add(tmpStr);
                helper(result, s.substring(i+1), tmp);
                tmp.remove(tmp.size()-1);
            }
        }
    }
    
    private boolean isPalindrome(String s){
        if(map.containsKey(s)){
            return map.get(s);
        }
        int end = s.length()-1;
        int start =0;
        while(start < end){
            if(s.charAt(start++) != s.charAt(end--)){
                map.put(s, false);
                return false;
            }
        }
        map.put(s, true);
        return true;
    }
}
