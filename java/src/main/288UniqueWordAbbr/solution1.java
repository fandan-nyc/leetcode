public class ValidWordAbbr {

    Map<String, Integer> data ;
    Set<String> dic ;
    public ValidWordAbbr(String[] dictionary) {
        dic = new HashSet<>();
        data = new HashMap<>();
        for(String i: dictionary){
            if(!dic.contains(i)){
                dic.add(i);
                String abbr = abbr(i);
                if(!data.containsKey(abbr)){
                    data.put(abbr, 0);
                }
                data.put(abbr, data.get(abbr)+1);
            }
        }
    }
    
    public boolean isUnique(String word) {
        if(word == null){
            return true;
        }
        String abbr = abbr(word);
        
        return (dic.contains(word) && data.get(abbr)==1) || data.containsKey(abbr) == false;
    }

    private String abbr(String x){
        if( x ==  null || x.length() <= 2){
            return x;
        }
        return x.charAt(0) + Integer.toString(x.length()-2) + x.charAt(x.length()-1);
    }
}



/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */
