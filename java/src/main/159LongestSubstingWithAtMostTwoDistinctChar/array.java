public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null){
            return 0;
        }else if(s.length() <= 1){
            return s.length();
        }
        int i = 0; 
        int j = -1; 
        int max = 0;
        for(int k = 1; k < s.length();k++){
            if(s.charAt(k) == s.charAt(k-1)){
                continue;
            }
            if(j > -1 && s.charAt(j) != s.charAt(k)){
                max = max > (k -i) ? max: (k-i);
                i = j+1;
            }
            j = k-1;
        }
        return max > (s.length() -i ) ? max :s.length() -i ;
    }
}
