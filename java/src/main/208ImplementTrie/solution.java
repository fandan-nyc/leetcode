
class TrieNode {
    // Initialize your data structure here.
     TrieNode[] children ;
     char val;
    boolean isEnd;
    public TrieNode(char input) {
        char val = input;
        children = new TrieNode[26];
    }
    public TrieNode(){
        children = new TrieNode[26];
    }
     
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode head = root;
        if(word == null || word.length() == 0){
            return;
        }
        for(int i = 0; i < word.length();i++){
            int pos = word.charAt(i)-'a';
            if(head.children[pos] == null){
                head.children[pos] = new TrieNode(word.charAt(i));
            }
            head =  head.children[pos];
        }
        head.isEnd = true;
    }

    private TrieNode searchHelper(String word){
        TrieNode head = root;
        for(int i = 0; i < word.length(); i++){
            int pos = word.charAt(i)-'a';
            if(head.children[pos] == null){
                return null;
            }
            head = head.children[pos];
        }
        return head;
    }
    // Returns if the word is in the trie.
    public boolean search(String word) {
       TrieNode result = searchHelper(word);
       if(result == null || result.isEnd == false){
           return false;
       }
       return true;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode result = searchHelper(prefix);
        return result !=null;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
