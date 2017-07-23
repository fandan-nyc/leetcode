public class Solution {
    public String licenseKeyFormatting(String st, int k) {
        if(st == null || st.length() == 0){
            return st;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = st.length()-1; i >= 0; i--){
            char tmp = Character.toUpperCase(st.charAt(i));
            if(tmp == '-'){
                continue;
            }
            if(sb.length() % (k+1) == k){
                sb.append("-");
            }
            sb.append(tmp);
        }
        return sb.reverse().toString();
    }
}
