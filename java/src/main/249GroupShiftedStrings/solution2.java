public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> store = new HashMap<>();
        for(String i: strings){
            String tmp = getTemplate(i);
            if(!store.containsKey(tmp)){
                store.put(tmp, new ArrayList<String>());
            }
            store.get(tmp).add(i);
        }
        List<List<String>> result = new ArrayList<>();
        for(String i: store.keySet()){
            result.add(store.get(i));
        }
        return result;
    }
    
    private String getTemplate(String str){
        int offset = str.charAt(0) - 'a';
        char[] result = new char[str.length()];
        for(int i = 0; i < str.length(); i++){
            char curr = (char)(str.charAt(i) - offset);
            result[i] = curr < 'a' ? (char)(curr + 26) : curr;
        }
        return new String(result);
    }
}
