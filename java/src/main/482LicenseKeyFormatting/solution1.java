public class Solution {
    public String licenseKeyFormatting(String st, int k) {
        if(st == null || st.length() == 0){
            return st;
        }
        Stack<Character> stack = new Stack<>();
        for(char i: st.toCharArray()){
            if(i == '-'){
                continue;
            }else if( i >= 'a' && i<= 'z'){
                stack.push((char)(i -'a' + 'A'));
            }else{
                stack.push(i);
            }
        }
        int tmp = k;
        StringBuilder sb = new StringBuilder();
        while( stack.isEmpty() == false){
            if(tmp > 0){
                sb.insert(0, stack.pop());
                tmp--;
            }else{
                sb.insert(0,'-');
                tmp = k;
            }
        }
        return sb.toString();
    }
}
