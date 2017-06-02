public class Solution {
    public String parseTernary(String expression) {
        Stack<Character> store = new Stack<Character>();
        for(char i: expression.toCharArray()){
            store.push(i);
        }
        Stack<Character> tmp = new Stack<Character>();
        while(store.size() > 1){
            while(store.peek() != '?'){
                tmp.push(store.pop());   
            }
            store.pop();
            char left = tmp.pop();
            tmp.pop();
            char right = tmp.pop();
            if(store.pop() == 'T'){
                store.push(left);
            }else{
                store.push(right);
            }
            while(tmp.size()!= 0){
                store.push(tmp.pop());
            }
        }
        return store.pop() + "";
    }
}
