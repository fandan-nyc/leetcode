public class WordDictionary {

    private final TrieNode root;
    
    public WordDictionary(){
        root = new TrieNode();
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode head =  root;
        for(int i = 0; i < word.length(); i++){
            int pos = word.charAt(i) - 'a';
            if(head.children[pos] == null){
                head.children[pos] = new TrieNode(word.charAt(i));
            }
            head = head.children[pos];
        }
        head.isEnd = true;
    }
    
    private boolean searchHelper(String word, TrieNode head){
        for(int i = 0; i < word.length(); i++){
            int pos = word.charAt(i) - 'a';
            if(word.charAt(i) != '.'){
                if(head.children[pos] == null){
                    return false;
                }else{
                    head = head.children[pos];
                }
            }else{
                for(int j = 0; j < 26;j++){
                    if(head.children[j] != null){
                        boolean result  =searchHelper(word.substring(i+1),head.children[j]);
                        if(result){
                            return true;
                        }
                    }
                }
                return false;
            }
        }
        return head.isEnd;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        TrieNode head = root;
        return searchHelper(word, head);
    }

 private class TrieNode{
        TrieNode[] children;
        char val;
        boolean isEnd;
        
        TrieNode(char input){
            val = input;
            children = new TrieNode[26];
        }
        
        TrieNode(){
            children = new TrieNode[26];
        }
    }
    
}


// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
