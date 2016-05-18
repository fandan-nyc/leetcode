public class Solution {
    private static final List<Character> vowels =  Arrays.asList('a','e','i','o','u','A','E','I','O','U');
    public String reverseVowels(String s) {
        char[] sArr = s.toCharArray();
        int left = 0 ; 
        int right = s.length()-1;
        while(left < right){
            while(left <= right && !vowels.contains(sArr[left])){
                ++left;
            }
            while(left <= right && !vowels.contains(sArr[right])){
                --right;
            }
            if(left < right){
                swap(sArr, left,right);
            }
            ++left;
            --right;
        }
        return new String(sArr);
    }
    
    private void swap(char[] arr, int i, int j){
        char tmp = arr[i];
        arr[i]= arr[j];
        arr[j] = tmp;
    }
}
