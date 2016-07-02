public class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> store = new HashMap<Character, Integer>();
        for(int i = 0; i < t.length(); i++){
            char x = t.charAt(i);
            Integer count = store.containsKey(x) ? store.get(x): 0;
            store.put(x, count+1);
        }
        int count = t.length();
        int left = 0; 
        int min = s.length()+1;
        int start = -1; 
        int end = -1;
        char[] sArr = s.toCharArray();
        for(int right = 0; right < s.length(); right++){
            char tmpS = sArr[right];
            if(store.containsKey(tmpS)){
                store.put(tmpS, store.get(tmpS)-1);
                if(store.get(tmpS) >= 0){
                    count --;
                }
            }
            while(left <= right && count == 0){
                // we cover all the chars;
                int currLen = right - left +1; 
                if(min > currLen){
                    start = left; 
                    end = right; 
                    min = currLen;
                }
                left = left +1;
                if(left <= right &&store.containsKey(sArr[left-1])){
                    int tmpCount = store.get(sArr[left-1])+1;
                    store.put(sArr[left-1], tmpCount);
                    if(tmpCount> 0){
                        count ++;
                    }
                }
            }
        }
        if(start == -1){
            return "";
        }
        return s.substring(start, end+1);
    }
}
