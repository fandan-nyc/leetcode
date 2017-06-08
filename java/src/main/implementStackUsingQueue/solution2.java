public class MyStack {

    /** Initialize your data structure here. */
    Queue<Integer> stack ;
    public MyStack() {
      stack =  new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        int count  = stack.size();
        stack.add(x);
        while(count >0){
            stack.add(stack.remove());
            count--;
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
       return stack.remove();
    }
    
    /** Get the top element. */
    public int top() {
        return stack.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return stack.isEmpty() ; 
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
