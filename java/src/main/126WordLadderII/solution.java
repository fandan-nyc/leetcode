public class Solution {
    
    private boolean isConnected ;
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        Set<String> start = new HashSet<String>();
        start.add(beginWord);
        Set<String> end = new HashSet<String>();
        end.add(endWord);
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        bfs(start, end, wordList, map, false);
        List<List<String>> result = new ArrayList<List<String>>();
        if(isConnected== false){
            return result;
        }
        assert (map.keySet().size() != 0);
        assert (map.get(beginWord).size() != 0);
        // for(String key: map.keySet()){
        //     result.add(map.get(key));
        // }
        // return result ;
        List<String> tmp = new ArrayList<String>();
        tmp.add(beginWord);
        dfs(beginWord, endWord, map, result, tmp);
        return result;
    }
    
    private void dfs(String begin, String end, Map<String, List<String>> map, List<List<String>> result, List<String> tmp){
        if(begin.equals(end)){
            result.add(new ArrayList<String>(tmp));
            return;
        }
        if(!map.containsKey(begin)){
            return;
        }
        for(String next: map.get(begin)){
            tmp.add(next);
            dfs(next, end, map, result, tmp);
            tmp.remove(tmp.size()-1);
        }
    } 
    
    private void bfs(Set<String> start, Set<String> end, Set<String> wordList, Map<String, List<String>>map, boolean swap){
        if(start.isEmpty() || end.isEmpty()){
            return;
        }
        if(start.size() > end.size()){
            bfs(end, start, wordList, map, !swap);
            return ; 
        }
        wordList.removeAll(start);
        wordList.removeAll(end);
        Set<String> nextLevel = new HashSet<String>();
        for(String startStr: start){
            char[] startArr =  startStr.toCharArray();
            for(int i = 0; i < startStr.length(); i++){
                for(char j = 'a'; j <= 'z'; j++){
                        final char original = startArr[i];
                        startArr[i] = j;
                        String newStr = new String(startArr);
                        if(!end.contains(newStr) && !wordList.contains(newStr)){
                            startArr[i] = original;
                            continue;
                        }
                        String key =  !swap ? startStr: newStr;
                        String value = !swap ? newStr: startStr;
                        if(!map.containsKey(key)){
                            map.put(key, new ArrayList<String>());
                        }
                        map.get(key).add(value);
                        if(end.contains(newStr)){
                            isConnected = true;
                        }
                        if(wordList.contains(newStr)){
                            nextLevel.add(newStr);
                        }
                        startArr[i] = original;
                }
            }
        }
        if(isConnected == true){
            return;
        }
        else{
            bfs(nextLevel, end, wordList, map, swap);
        }
    }
}

