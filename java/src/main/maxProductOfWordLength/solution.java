public class Solution {
    public int maxProduct(String[] words) {
        int[] wordsCode = new int[words.length];
        for(int i = 0 ; i < words.length; i ++){
            wordsCode[i] = stringToInt(words[i]);
        }
        int max = 0 ;
        for(int i = 0; i < words.length-1; i ++){
            for(int j = i+1; j < words.length; j++){
                if((wordsCode[i] & wordsCode[j]) == 0){
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }
    
    private int stringToInt(String input){
        int result  = 0;
        for(int i = 0; i < input.length(); i++){
            result |= (1 << (input.charAt(i) -'a'));
        }
        return result;
    }
}
