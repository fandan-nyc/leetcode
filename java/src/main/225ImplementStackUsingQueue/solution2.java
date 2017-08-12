public class MyStack {

    /** Initialize your data structure here. */
    Queue<Integer> first; 
    Queue<Integer> second;
    public MyStack() {
        first = new LinkedList<>();
        second = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        // push is O(n)
        second.add(x);
        while(first.isEmpty() == false){
            second.add(first.remove());
        }
        Queue<Integer> tmp = first;
        first = second; 
        second = tmp;
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        // pop is O(1)
        return first.remove();
    }
    
    /** Get the top element. */
    public int top() {
        return first.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return first.isEmpty() && second.isEmpty();
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
