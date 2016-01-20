c class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null)
            return -1; 
        if(needle.equals("")){
            return 0;
        }
        if(haystack.equals("")){
            return -1;
        }
        int[] next = next(needle);
        int m = 0; // starting check point in haystack
        int i = 0; // current pos in needle
        while(m+i < haystack.length()){
            if(haystack.charAt(m+i) == needle.charAt(i)){
                i++;
                if(i == needle.length()){
                return m;
            }
            
            }
            else{
                if(next[i] == -1){
                    i = 0;
                    m++;
                }
                else{
                    m = m+i - next[i];
                    i =next[i];
                }
            }
        }
        return -1;
    }
    
    private int[] next(String needle){
        int[] next = new int[needle.length()];
        next[0] = -1;
        int k = -1; 
        int j = 0; 
        while(j < needle.length()-1){
            if(k ==-1 || needle.charAt(j) == needle.charAt(k)){
                k++;
                j++;
                next[j] = k;
            }
            else{
                k = next[k];
            }
        }
        return next;
    }
}
