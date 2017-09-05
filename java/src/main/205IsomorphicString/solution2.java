class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s == null || t == null || s.length() != t.length()){
            return false;
        }
        int[] sStore = new int[256];
        int[] tStore = new int[256];
        for(int i = 0; i < s.length(); i++){
            if(sStore[s.charAt(i)] != tStore[t.charAt(i)]){
                return false;
            }
            sStore[s.charAt(i)] = i+1;
            tStore[t.charAt(i)] = i+1;   
        }
        return true;
    }
}
