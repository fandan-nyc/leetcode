public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if(beginWord == null || endWord == null || beginWord.equals(endWord) || wordList == null || wordList.size() == 0){
            return 0;
        }
        return helper(beginWord, endWord, wordList);
    }
    
    private int helper(String begin, String end, Set<String> list){
        list.remove(begin);
        int level  = 0;
        Queue<String> queue = new LinkedList<String>();
        queue.add(begin);
        while(!queue.isEmpty()){
            int size = queue.size(); 
            while(size > 0){
                String tmp = queue.poll(); 
                if(tmp.equals(end)){
                    return level +1;
                }
                char[] wordArr = tmp.toCharArray();
                for(char i = 'a' ; i <= 'z' ; i++){
                    for(int j = 0; j < wordArr.length;j++){
                        if(i != wordArr[j]){
                            char tmpChar = wordArr[j];
                            wordArr[j] = i;
                            String newWord = new String(wordArr);
                            if(list.contains(newWord)){
                                queue.add(newWord);
                                list.remove(newWord);
                            }
                            wordArr[j] = tmpChar;
                        }
                    }
                }
                size -- ;
            }
            ++level;
        }
        return 0;
    }
}
