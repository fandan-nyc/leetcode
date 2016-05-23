public class Solution {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int start = 0;
        int end = s.length()-1;
        while(start < s.length() && arr[start] == ' '){
            start++;
        }
        while(end >= 0 && arr[end] == ' '){
            end --;
        }
        if(start > end){
            return new String("");
        }
        int i = start;
        int j
        while(i <= end){
            if( arr[i] == ' ' && arr[i-1] == ' '){
                int j = i;
                while(j < end){
                    arr[j] = arr[j+1];
                    j++;
                }
                --i;
                end--;
            }
            ++i;
        }
        reverse(arr,start, end);
        for(int k = start; k <= end; k++){
            int j = k;
            while(j <= end && arr[j] !=' '){
                j++;
            }
            reverse(arr,k,j-1);
            k = j;
        }
        return new String(arr, start, end-start+1);
    }
    
    private void reverse(char[] arr, int i, int j){
        while(i < j){
            swap(arr, i++,j--);
        }
    }
    
    private void swap(char[] arr, int i , int j){
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
