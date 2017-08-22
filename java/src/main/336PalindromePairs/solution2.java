class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        TrieNode head = buildTrie(words);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < words.length; i++){
            String first = words[i];
            List<Integer> tmp = search(first, head, i);
            for(int j: tmp){
                if(isPalindrome(first, words[j])){
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res ; 
    }
    
    private List<Integer> search(String str, TrieNode head, int currentIndex){
        List<Integer> res = new ArrayList<>();
        if(head.isEnd && head.index != currentIndex){
            res.add(head.index);
        }
        for(int i = 0; i < str.length(); i++){
            char curr = str.charAt(i);
            TrieNode next = head.next[curr-'a'];
            if(next == null){
                break;
            }else{
                if(next.isEnd == true && next.index != currentIndex){
                    res.add(next.index);
                }
                head = next;
            }
        }
        Queue<TrieNode> queue = new LinkedList<>();
        for(TrieNode i: head.next){
            if(i != null){
                queue.add(i);
            }
        }
        while(queue.isEmpty() == false){
            TrieNode tmp = queue.remove();
            if(tmp.isEnd && tmp.index != currentIndex){
                res.add(tmp.index);
            }
            for(TrieNode a: tmp.next){
                if(a != null){
                    queue.add(a);
                }
            }
        }
        return res ; 
    }
    
    private TrieNode buildTrie(String[] words){
        TrieNode head = new TrieNode((char)0);
        TrieNode pt = head;
        for(int i = 0; i < words.length; i++){
            String str = words[i];
            pt = head;
            for(int j = str.length()-1; j >= 0; j--){
                char curr = str.charAt(j);
                if(pt.next[curr- 'a'] == null){
                    pt.next[curr - 'a'] = new TrieNode(curr);
                }
                pt = pt.next[curr- 'a'];
            }
            pt.isEnd = true;
            pt.index = i;
        }
        return head ;
    }
    
    private boolean isPalindrome(String a, String b){
        String tmp = a +b;
        int i = 0; 
        int j = tmp.length()-1;
        while(i < j){
            if(tmp.charAt(i) != tmp.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

class TrieNode {
    char val;
    TrieNode[] next;
    boolean isEnd = false;
    int index = -1;
    TrieNode(char val){
        this.val = val;
        next = new TrieNode[26];
    }
}
