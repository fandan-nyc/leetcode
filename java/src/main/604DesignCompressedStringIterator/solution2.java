public class StringIterator {
    
    private Node node ;
    private Queue<Character> queue;
    

    public StringIterator(String compressedString) {
        queue = new LinkedList<>();
        for(char i: compressedString.toCharArray()){
            queue.add(i);
        }
        node = new Node('a',0);
    }
    
    public char next() {
        if(hasNext()){
            if(node.count == 0){
                char tmpVal = queue.remove();
                int total = getNum(queue);
                node.val = tmpVal;
                node.count = total;   
            }
            node.count--;
            return node.val;
        }
        return ' ';
    }
    
    private boolean isNum(char a ){
        return a >= '0' && a <= '9';
    }
    
    private int getNum(Queue<Character> queue){
        int total = 0;
        while(queue.isEmpty() == false && isNum(queue.peek())){
            total = total * 10 + (queue.remove() - '0');
        }
        return total;
    }
    
    public boolean hasNext() {
        return !(node.count == 0 && queue.isEmpty());
    }
}

class Node {
    char val; 
    int count;
    
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
