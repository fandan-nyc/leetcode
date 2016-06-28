public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if(s == null || s.length() <= 10){
            return new ArrayList<String>();
        }
        Map<String, Integer> store = new HashMap<String, Integer>();
        for(int i = 0; i <= s.length() -10;i++){
            String tmp = s.substring(i, i+10);
            int count = store.containsKey(tmp) ? store.get(tmp):0 ;
            store.put(tmp, count+1);
        }
        List<String> result = new ArrayList<String>();
        for(Map.Entry<String, Integer> entry: store.entrySet()){
            if(entry.getValue() > 1){
                result.add(entry.getKey());
            }
        }
        return result;
    }
}
