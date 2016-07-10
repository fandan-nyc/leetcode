
public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
     //   https://discuss.leetcode.com/topic/33246/java-15ms-easiest-solution-100-00
        List<String> result = new ArrayList<String>();
        if(board == null || board.length == 0|| board[0].length == 0 || words == null || words.length == 0){
            return result;
        }
        final Trie trie = new Trie();
        // create the trie;
        for(String i: words){
            trie.insert(i);
        }
        Set<String> tmpResult = new HashSet<String>();
        for(int i = 0; i < board.length; i++){
            for(int j = 0;  j < board[0].length; j++){
                backTracking(board, trie, "", tmpResult, i,j);
            }
        }
        for(String i: tmpResult){
            result.add(i);
        }
        return result;
    }
    
    
    private void backTracking(char[][] board, Trie trie, String tmp, Set<String> result, int i, int j){
        if(i < 0 || i >= board.length || j < 0 || j >=board[0].length){
            return; 
        }
        else if(board[i][j] == '#'){
            return;
        }
        char curr = board[i][j];
        tmp = tmp + curr;
        if(!trie.startWith(tmp)){
            return;
        }
        if(trie.search(tmp)){
            result.add(new String(tmp));
        }
        char original = board[i][j];
        board[i][j] = '#';
        backTracking(board, trie, tmp , result, i-1, j);
        backTracking(board, trie, tmp , result, i+1, j);
        backTracking(board, trie, tmp , result, i, j-1);
        backTracking(board, trie, tmp , result, i, j+1);
        board[i][j] = original;
    }
    
    private class Trie{
        final private TrieNode root ; 
        Trie(){
            root = new TrieNode();
        }
        
        void insert(String input){
            TrieNode tmp = root ; 
            for(int i = 0; i < input.length(); i++){
                char curr = input.charAt(i);
                int pos = curr - 'a';
                if(tmp.children[pos] == null){
                    tmp.children[pos] = new TrieNode(curr);
                }
                tmp = tmp.children[pos];
            }
            tmp.isEnd = true;
        }
        
        private TrieNode searchHelper(String input){
            TrieNode tmp = root;
            for(int i = 0; i < input.length(); i++){
                char curr = input.charAt(i);
                int pos = curr - 'a';
                if(tmp.children[pos] == null){
                    return null;
                }
                tmp = tmp.children[pos];
            }
            return tmp;
        }
        
        boolean startWith(String input){
            TrieNode curr = searchHelper(input);
            return curr != null;
        }
        
        boolean search(String input){
            TrieNode curr = searchHelper(input);
            return (curr != null && curr.isEnd) ;
            // one time search
            // if(result){
            //     curr.isEnd = false;
            // }
           // return result;
        }
    }

    private class TrieNode{
        boolean isEnd ; 
        TrieNode[] children ;
        char var ;
        
        TrieNode(){
            children = new TrieNode[26];
        }
        
        TrieNode(char input){
            children = new TrieNode[26];
            var = input;
        }
    }
}

