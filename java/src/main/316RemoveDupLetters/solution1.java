class Solution {
    public String removeDuplicateLetters(String s) {
        if(s == null){
            return s;
        }
        int[] data  = new int[26];
        Arrays.fill(data, -1);
        for(int i = 0; i < s.length(); i++){
            data[s.charAt(i) - 'a'] = i;
        }
        // above, find the last time we see char X at position Y in s
        // if char X' never appears in s, then the position is -1
        int start = 0;
        int end = getMinPosInData(data);
        StringBuilder sb = new StringBuilder();
        while(end != -1){
            int posInString = data[end];
            int tmp = getMinChar(s, start, posInString, data);
            start = tmp +1;
            sb.append(s.charAt(tmp));
            // since s.charAt(tmp) has been used, we remove it from the data array
            data[s.charAt(tmp) - 'a'] = -1;
            end = getMinPosInData(data);
        }
        return sb.toString();
    }
    
    private int getMinChar(String s, int start, int end, int[] data){
        char res = 'z' +1;
        int pos = -1;
        for(int i= start; i <= end; i++){
            if(res > s.charAt(i) && data[s.charAt(i) - 'a'] != -1){
                res = s.charAt(i);
                pos = i;
            }
        }
        return pos;
    }
    
    // the smallest number in data
    // [a: 9, b: 2, z: 4]
    // then return 2
    // otherwise, return -1
    // if getMinPosInData returns 5
    // for sure we need to pick the smallest char between start and 5, otherwise, the char whose last appearance in spot 5 will never be picked up
    // this method returns which position in data that contains the smallest pos in str 
    // it is complicated i know
    private int getMinPosInData(int[] data){
        int min = Integer.MAX_VALUE;
        int pos = -1;
        for(int i = 0; i < data.length; i++){
            if(data[i] != -1 && data[i] < min){
                min = data[i];
                pos = i;
            }
        }
        return pos;
    }
}
