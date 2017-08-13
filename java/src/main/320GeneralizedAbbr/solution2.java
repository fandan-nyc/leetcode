public class Solution {
    public List<String> generateAbbreviations(String word) {
        if(word == null ){
            return new ArrayList<String>();
        }else if(word.equals("")){
            return Arrays.asList("");
        }
        List<String> res = helper(word);
        return res ;         
    }
    
    private List<String> helper(String word){
        if(word.length() == 1){
            return new ArrayList(Arrays.asList(word, "1"));
        }
        List<String> cur = helper(word.substring(1));
        int size = cur.size();
        for(int i = 0; i < size; i++){
            String tmp = cur.get(i);
            // current char
            cur.set(i, word.charAt(0) +tmp);
            if(isAlpha(tmp.charAt(0))){
                cur.add("1" + tmp);
            }else{
                int count = 0;
                while(count < tmp.length()){
                    if(isAlpha(tmp.charAt(count))){
                        break;
                    }
                    count++;
                }
                cur.add( (1 + Integer.valueOf(tmp.substring(0, count))) + tmp.substring(count));
            }
        }
        return cur;
    }
    
    private boolean isAlpha(char i){
        return  i>= 'a' && i <='z';
    }
}
