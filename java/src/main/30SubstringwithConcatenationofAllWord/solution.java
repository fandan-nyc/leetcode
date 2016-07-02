public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<Integer>();
        if(s == null || words ==  null || words.length == 0 || s.length() < words.length * words[0].length()){
            return result;
        }
        Map<String, Integer> map = new HashMap<String, Integer>(); 
        for( String i: words){
            int count = map.containsKey(i) ? map.get(i):0;
            map.put(i, count+1);
        }
        int wordLen = words[0].length();
        int right = 0;
        int left;
        for(int start  = 0; start < wordLen; start++){
            Queue<Integer> pos = new LinkedList();
            Map<String, Integer> currMap = new HashMap<String, Integer>(map);
            int count =0;
            for( right = start; right <= s.length() - wordLen; right+= wordLen){
                String tmp = s.substring(right, right+ wordLen);
                if( !currMap.containsKey(tmp)){
                    continue;
                }else{
                    pos.add(right);
                    while(currMap.get(tmp) < 1){
                        left = pos.poll();
                        String leftTmp = s.substring(left, left + wordLen);
                        currMap.put(leftTmp, currMap.get(leftTmp)+1);
                        count --;
                    }
                    currMap.put(tmp, currMap.get(tmp) -1);
                    count ++;
                    if(count == words.length && pos.isEmpty() == false && right + wordLen -pos.peek() == wordLen * words.length){
                        result.add(pos.peek());
                    }
                }
            }
        }
     return result;
    }
}
