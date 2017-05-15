public class Solution {
    public boolean isStrobogrammatic(String num) {
        int start = 0; 
        int end = num.length()-1;
        char[] stroMap = new char[256];
        stroMap['0'] = '0';
        stroMap['1'] = '1';
        stroMap['8'] = '8';
        stroMap['6'] = '9';
        stroMap['9'] = '6';
        
        while(start <= end){
            char startChar = num.charAt(start);
            char endChar = num.charAt(end);
            if(stroMap[startChar] != endChar){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
