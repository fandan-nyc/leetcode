public class Solution {
    public void reverseWords(char[] s) {
        if(s == null || s.length == 0){
            return;
        }
        reverse(s, 0, s.length-1);
        int start  = 0;
        int end = 0;
        while(end < s.length){
            if(s[end] != ' '){
                end++;
            }
            else{
                reverse(s, start, end-1);
                start = end+1;
                end++;
            }
        }
        reverse(s, start, end-1);
    }
    
    private void reverse(char[] s, int start, int end){
        while(start < end){
            swap(s,start, end);
            start ++;
            end --;
        }
    }
    
    private void swap(char[] s, int a, int b){
        char tmp = s[a];
        s[a] =  s[b];
        s[b] = tmp;
    }
}
