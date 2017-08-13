public class Solution {
    public List<String> generateAbbreviations(String word) {
        if(word == null ){
            return new ArrayList<String>();
        }else if(word.equals("")){
            return Arrays.asList("");
        }
        Set<String> tmp = helper(word);
        List<String> res = new ArrayList<>();
        for(String i: tmp){
            res.add(convert(i));
        }
        return res ; 
        // f(n) = f(n-1)
        
    }
    
    private Set<String> helper(String word){
        if(word.length() == 1){
            return new HashSet<String>(Arrays.asList(word, "1"));
        }
        Set<String> cur = helper(word.substring(1));
        Set<String> rest = new HashSet<String>();
        for(String i: cur){
            rest.add(word.charAt(0) + i);
            rest.add("1" + i);
        }
        return rest;
    }
    
    private String convert(String word){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < word.length() ; i++){
            if(isAlpha(word.charAt(i))){
                sb.append(word.charAt(i));
            }else{
                int tmp = 0;
                while(i < word.length() && !(isAlpha(word.charAt(i)))){
                    tmp += (word.charAt(i) - '0');
                    i++;
                }
                sb.append(tmp+"");
                i--;
            }
        }
        return sb.toString();
    }
    
    private boolean isAlpha(char i){
        return  i>= 'a' && i <='z';
    }
}
