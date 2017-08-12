public class MyStack {

    /** Initialize your data structure here. */
    Queue<Integer> first ;
    Queue<Integer> second ;
    public MyStack() {
        first = new LinkedList<>();
        second = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        if(!first.isEmpty()){
            second.add(first.remove());
        }
        first.add(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int result = first.remove();
        while(second.size() > 1){
            first.add(second.remove());
        }
        Queue<Integer> tmp = first;
        first = second; 
        second = tmp;
        return result;
    }
    
    /** Get the top element. */
    public int top() {
        return first.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return first.isEmpty() && second.isEmpty() ; 
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
