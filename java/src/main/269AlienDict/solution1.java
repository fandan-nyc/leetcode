class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Node> dict = prepareData(words);
        Map<Character, Integer> indegree = prepareIndegree(dict);        
        Queue<Character> queue = new LinkedList<>();
        for(char i: indegree.keySet()){
            if(indegree.get(i) == 0){
                queue.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            char tmp = queue.remove();
            sb.append(tmp);
            for(char i: dict.get(tmp).next){
                indegree.put(i, indegree.get(i)-1);
                if(indegree.get(i) == 0){
                    queue.add(i);
                }
            }
        }
        return sb.length() == dict.size() ? sb.toString(): "";
    }
    
    private Map<Character, Node> prepareData(String[] words){ 
        Map<Character, Node> dict = new HashMap<>();
        for(int i = 0; i < words.length; i++){
            String currStr = words[i];
            char prev = 0;
            for(int j = 0; j < currStr.length() ; j++){
                char currChar = currStr.charAt(j);
                if(!dict.containsKey(currChar)){
                    dict.put(currChar, new Node(currChar));
                }
                if(prev != 0 && prev != currChar){
                    dict.get(prev).next.add(currChar);
                    prev = currChar;
                }
            }
            if( i > 0){
                String prevStr = words[i-1];
                if(!prevStr.equals(currStr)){
                    for(int k = 0; k < prevStr.length() && k < currStr.length(); k++){
                        if(prevStr.charAt(k) != currStr.charAt(k)){
                            dict.get(prevStr.charAt(k)).next.add(currStr.charAt(k));
                            break;
                        }
                    }
                }
            }
        }
        return dict;
    }
    
    public Map<Character, Integer> prepareIndegree(Map<Character, Node> dict){
        Map<Character, Integer> indegree = new HashMap<>();
        for(Map.Entry<Character, Node> entry: dict.entrySet()){
            indegree.putIfAbsent(entry.getKey(), 0);
            for(char i: entry.getValue().next){
                indegree.put(i,indegree.getOrDefault(i, 0)+1);
            }
        }
        return indegree;
    }
}


class Node {
    char val ;
    Set<Character> next ;
    Node(char val){
        this.val = val;
        next = new HashSet<>();
    }
}
