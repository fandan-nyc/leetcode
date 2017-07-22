public class StringIterator {

    Queue<Character> queue = new LinkedList<Character>();
    
    public StringIterator(String compressedString) {
        char curr ;
        int len = compressedString.length();
        for(int i = 0; i < len; i++){
            if(!isNumber(compressedString, i)){
                int num = getCharNum(compressedString, i+1);
                while(num > 0){
                    queue.add(compressedString.charAt(i));
                    num--;
                }
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
        return queue.isEmpty()? ' ' : queue.remove();
    }
    
    public boolean hasNext() {
        return queue.isEmpty() == false;
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
