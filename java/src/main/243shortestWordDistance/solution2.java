public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int min = Integer.MAX_VALUE;
        int pos1 = -1 * words.length;
        int pos2 = -1 * words.length;
        int current = 0;
        for(int i = 0; i < words.length; i++){
            if(words[i].equals(word1)){
                pos1 = i;
                current = pos1 - pos2 ; 
            }else if(words[i].equals(word2)){
                pos2 = i;
                current = pos2 - pos1 ; 
            }else{
                continue;
            }
            min = min > current ? current: min;
        }
        return min;
    }
}
