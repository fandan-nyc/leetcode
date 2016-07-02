public class Solution {
    
    // insteaf of concate the two words, cal if it is palindrome, what we can do is:
    // for a string, check the possible ones which make a palindrome, and search if the possible 
    // solution is in the HashMap
    
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(words == null){
            return result;
        }
        Map<String, Integer> map = new HashMap<String, Integer>(); 
        for(int i = 0; i < words.length; i++){
            map.put(words[i],i);
        }
        for(int i = 0; i < words.length; i++){
            String tmp = words[i];
            for(int j = 0; j <= tmp.length(); j++){
                String prefix = tmp.substring(0,j);
                String suffix = tmp.substring(j);
                if(isPalindrome(prefix)){
                    String reverseSuffix = new StringBuilder(suffix).reverse().toString();
                    Integer pos = map.get(reverseSuffix);
                    if(pos != null && pos != i){
                            result.add(Arrays.asList(pos, i));
                    }
                }
                if(isPalindrome(suffix)){
                    String reversePrefix = new StringBuilder(prefix).reverse().toString();
                    Integer pos = map.get(reversePrefix);
                    if(!suffix.equals("") &&pos != null && pos != i){
                        result.add(Arrays.asList(i, pos));
                    }
                }
            }
        }
        return result;
    }
    
    private boolean isPalindrome(String result){
        int i = 0; 
        int j = result.length()-1;
        char[] array = result.toCharArray();
        while(i < j){
            if(array[i] != array[j]){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
