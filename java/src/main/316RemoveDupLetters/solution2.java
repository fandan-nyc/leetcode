class Solution {
    public String removeDuplicateLetters(String s) {
        if(s == null){
            return s;
        }
        Map<Character, Integer> data = new HashMap<>();       
        for(int i = 0; i < s.length(); i++){
            data.put(s.charAt(i), i);
        }
        // above, find the last time we see char X at position Y in s
        int start = 0;
        int end = getMinLastPos(data);
        StringBuilder sb = new StringBuilder();
        while(end != Integer.MAX_VALUE){
            int tmp = getMinChar(s, start, end, data);
            start = tmp + 1;
            sb.append(s.charAt(tmp));
            // since s.charAt(tmp) has been used, we remove it from the data array
            data.remove(s.charAt(tmp));
            end = getMinLastPos(data);
        }
        return sb.toString();
    }
    
    private int getMinChar(String s, int start, int end, Map<Character, Integer> data){
        char res = 'z' +1;
        int pos = -1;
        for(int i= start; i <= end; i++){
            if(res > s.charAt(i) && data.containsKey(s.charAt(i))){
                res = s.charAt(i);
                pos = i;
            }
        }
        return pos;
    }
    
    // the smallest number in data
    // [a: 9, b: 2, z: 4]
    // then return 2
    private int getMinLastPos(Map<Character, Integer> data){
        int pos = Integer.MAX_VALUE;
        for(Character i: data.keySet()){
            pos = Math.min(data.get(i), pos);
        }
        return pos;
    }
}
