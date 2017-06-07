public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        return prefixHelper(strs, 0, strs.length-1);
    }
    
    private String prefixHelper(String[] strs, int a, int b){
        if(a == b){
            return strs[a];
        }else{
            int mid = (a+b)/2;
            String left = prefixHelper(strs, a, mid);
            String right =  prefixHelper(strs, mid+1, b);
            return commonPrefix(left, right);
        }
    }
    
    private String commonPrefix(String a, String b){
        for(int i = 0; i < a.length(); i++){
            if(i >= b.length() || a.charAt(i) != b.charAt(i)){
                return a.substring(0,i);
            }
        }
        return a;
    }
}
