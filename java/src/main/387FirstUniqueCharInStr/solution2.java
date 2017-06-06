public class Solution {
    public int firstUniqChar(String s) {
        if(s == null || s.length() == 0){
            return -1;
        }
        int[] alp = new int[26];
        Arrays.fill(alp, -2);
        for(int i = 0; i < s.length() ; i++){
            int curr = s.charAt(i) - 'a';
            if(alp[curr] == -2){
                alp[curr] = i;
            }else{
                alp[curr] = -1;
            }
        }
        int min = s.length();
        for(int i = 0; i < 26;i++){
            if(alp[i] >=0)
                min = Math.min(min, alp[i]);
        }
        return min == s.length() ? -1: min;
    }
}
