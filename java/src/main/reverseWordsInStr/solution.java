public class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        char[] data = s.toCharArray();
        data = removeExtraSpace(data);
        reverse(data, 0, data.length-1);
        int start = 0;
        for(int i = 0; i < data.length; i++){
            if(data[i] == ' '){
                reverse(data, start, i-1);
                start = i+1;
            }
        }
        if(start < data.length){
            reverse(data, start, data.length-1);
        }
        return new String(data);
    }
    
    private char[] removeExtraSpace(char[] data){
        int next = 0;
        boolean remove = false;
        for(int i = 0; i < data.length; i++){
            if(i > 0 && data[i] == ' ' && data[i-1] == ' '){
                remove = true;
            }else{
                remove = false;
            }
            if(remove == false){
                data[next] = data[i];
                next++;
            }
        }
        return Arrays.copyOfRange(data, 0, next);
    }
    
    private void reverse(char[] data, int start, int end){
        while(start < end){
            swap(data, start,end);
            start++;
            end--;
        }
    }
    
    private void swap(char[] data, int a, int b){
        char tmp = data[a];
        data[a] = data[b];
        data[b] = tmp;
    }
}
