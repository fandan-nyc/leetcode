public class WordDistance {

    Map<String, List<Integer>> store ;
    Map<String, Map<String, Integer>> result ; 
    public WordDistance(String[] words) {
        store = new HashMap<>();
        addWordsToMap(store, words);
        result = new HashMap<>();
    }
    
    private void addWordsToMap(Map<String, List<Integer>> store, String[] words){
        for(int i  = 0; i < words.length; i++){
            String curr = words[i];
            if(store.containsKey(curr)){
                store.get(curr).add(i);
            }else{
                List<Integer> pos = new LinkedList<>();
                pos.add(i);
                store.put(curr, pos);
            }
        }   
    }
    
    private int calcDis(String a, String b){
        int min = Integer.MAX_VALUE;
        List<Integer> first = store.get(a);
        List<Integer> second = store.get(b);
        
        for(int i = 0,  j = 0; i < first.size() && j < second.size();){
            int iValue = first.get(i);
            int jValue = second.get(j);
            if( iValue < jValue){
                min = Math.min( min, jValue - iValue);
                i++;
            }else{
                min = Math.min( min, iValue - jValue);
                j++;
            }
        }
        return min;
    }
    
    public int shortest(String word1, String word2) {
        if(store.containsKey(word1) == false || store.containsKey(word2) == false){
            throw new IllegalArgumentException( word1 + " or " + word2 + " not stored");
        }
        if(result.containsKey(word1) && result.get(word1).containsKey(word2)){
            return result.get(word1).get(word2);
        }else if(result.containsKey(word2) && result.get(word2).containsKey(word1)){
            return result.get(word2).get(word1);
        }else{
            int distance = calcDis(word1, word2);
            if(result.containsKey(word1)){
                result.get(word1).put(word2, distance);
                return distance;
            }else{
                Map<String, Integer> tmp  = new HashMap<>();
                tmp.put(word2, distance);
                result.put(word1, tmp);
                return distance;
            }
        }
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */
