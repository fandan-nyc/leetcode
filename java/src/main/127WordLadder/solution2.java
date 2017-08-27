class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, Set<String>> map = prepareMap(wordList);
        map.put(beginWord, new HashSet<String>());
        for(String i: wordList){
            if(hasLetterDiff(beginWord, i)){
                map.get(beginWord).add(i);
            }
        }
        if(map.containsKey(endWord) == false){
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int count = 1;
        Set<String> visited = new HashSet<>();
        while(queue.isEmpty() == false){
            int size = queue.size();
            count++;
            while(size > 0){
                String curr = queue.remove();
                for(String i: map.get(curr)){
                     if(visited.contains(i)){
                        continue;
                    }
                    if(i.equals(endWord)){
                        return count;
                    }
                    queue.add(i);
                    visited.add(i);
                }
                size--;
            }
        }
        return 0;
    }
    
    private Map<String, Set<String>> prepareMap(List<String> wordList ){
        Map<String, Set<String>> map = new HashMap<>();
        for(int i = 0; i < wordList.size(); i++){
            for(int j = i+1; j < wordList.size(); j++){
                String a = wordList.get(i);
                String b = wordList.get(j);
                if(hasLetterDiff(a, b)){
                    map.putIfAbsent(a, new HashSet<String>());
                    map.putIfAbsent(b, new HashSet<String>());
                    map.get(a).add(b);
                    map.get(b).add(a);
                }
            }
        }
        return map;
    }
    
    private boolean hasLetterDiff(String a, String b){
        if(a.length() == b.length()){
            int counter = 0;
            while(counter < a.length()){
                if(a.charAt(counter) == b.charAt(counter)){
                    counter++;   
                }else{
                    break;
                }
            }
            if(counter != a.length()){
                return a.substring(counter+1).equals(b.substring(counter+1));
            }
        }
        return false;
    }
}
