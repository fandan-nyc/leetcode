public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
       List<List<String>> result = new ArrayList<List<String>>();
       Set<String> used = new HashSet<>();
       for(int i = 0; i < strings.length; i++){
           String curr = strings[i];
           if(used.contains(curr)){
               continue;
           }else{
               used.add(curr);
               int[] pattern = getPattern(curr);
               List<String> tmp = new ArrayList<>();
               tmp.add(curr);
               for(int j = i+1; j < strings.length; j++){
                   if(sameGroup(pattern, strings[j])){
                       used.add(strings[j]);
                       tmp.add(strings[j]);
                   }
               }
               result.add(tmp);
           }
       }
       return result;
    }
    
    private int[] getPattern(String a){
        int[] pattern = new int[a.length()];
        for(int i = 1; i < a.length(); i++){
            int diff = a.charAt(i) - a.charAt(i-1);
            diff = diff < 0 ? diff+26:diff;
            pattern[i-1] = diff; 
        }
        return pattern;
    }
    
    private boolean sameGroup(int[] pattern, String b){
        if(b.length() != pattern.length){
            return false;
        }else{
            for(int i = 1; i < b.length(); i++){
                int diff = b.charAt(i) - b.charAt(i-1);
                diff = diff < 0 ? diff+26:diff;
                if(pattern[i-1] != diff){
                    return false;
                }
            }
            return true;
        }
    }
}
