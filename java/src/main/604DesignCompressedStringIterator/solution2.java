public class StringIterator {

    Queue<Node> queue = new LinkedList<Node>();
    
    public StringIterator(String compressedString) {
        char curr ;
        int len = compressedString.length();
        for(int i = 0; i < len; i++){
            if(!isNumber(compressedString, i)){
                int num = getCharNum(compressedString, i+1);
                queue.add(new Node(compressedString.charAt(i), num));
            }
        }
    }
    
    private int getCharNum(String st, int pos){
        if(pos >= st.length()){
            return 1;
        }
        if(!isNumber(st, pos)){
            return 1;
        }else{
            int number = 0; 
            while(pos < st.length() && isNumber(st, pos)){
                number = number * 10 + st.charAt(pos) - '0';
                pos++;
            }
            return number ; 
        }
    }
    
    private boolean isNumber(String st, int pos){
        return st.charAt(pos) >= '0' && st.charAt(pos) <= '9';
    }
    
    public char next() {
        if(queue.isEmpty()){
            return ' ';
        } else{
            char res  = queue.peek().val;
            queue.peek().count--;
            if(queue.peek().count == 0){
                queue.remove();
            }
            return res;
        }
    }
    
    public boolean hasNext() {
        return queue.isEmpty() == false;
    }
}

class Node {
    public int count ; 
    public char val;
     
    Node(char val, int count){
        this.val = val;
        this.count = count;
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
