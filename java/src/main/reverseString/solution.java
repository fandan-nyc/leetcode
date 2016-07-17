public class Solution {
    public String reverseString(String s) {
        if( s == null || s.length() <= 1){
            return s;
        }
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        for(int i = len -1; i >= 0;i --){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
    
     public String reverseStringII(String s) {
       if(s == null || s.length() <=1 ){
           return s;
       }
       char[] arr = s.toCharArray();
       for(int i = 0; i < arr.length/2; i++){
           char tmp = arr[arr.length -i-1];
           arr[arr.length -i-1] = arr[i];
           arr[i]=tmp;
       }
       return new String(arr);
    }

    public String reverseStringIII(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
}
