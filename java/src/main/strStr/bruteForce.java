public class Solution {
    public int strStr(String haystack, String needle) {
        //brute force
        for(int i = 0; i <= haystack.length() - needle.length(); i ++){
        	int k = i;
        	for(int j = 0; j < needle.length();j++){
        		if(haystack.charAt(k) != needle.charAt(j)){
        			break;
        		}
        		k++;
        	}
        	if(k  - i == needle.length()){
        		return i;
        	}
        }
        return -1;
    }
}
