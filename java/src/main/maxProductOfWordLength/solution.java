public class Solution {
    public int maxProduct(String[] words) {
    if(words == null || words.length <= 1){
        return 0;
    }
    int[] mark = new int[words.length];
    for(int i= 0; i < words.length; i ++){
        for(int j = 0; j < words[i].length(); j++){
            mark[i] |= 1 << (words[i].charAt(j) - 'a');
        }
    }
    int max = 0;
    for( int i = 0; i < words.length -1; i++)
        for(int j = i; j < words.length; j++ ){
            if( (mark[i] & mark[j])== 0){
                max = Math.max(words[i].length() * words[j].length(), max);
            }
    }
    return max;
    }
}
