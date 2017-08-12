public class MyStack {

    /** Initialize your data structure here. */
    Queue<Integer> first; 
    Queue<Integer> second;
    Integer top;
    public MyStack() {
        first = new LinkedList<>();
        second = new LinkedList<>();
        top = null;
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        // push is O(1)
        first.add(x);
        top = x;
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        // pop is O(n)
        // iterate all the way to the tail to pop
        while(first.size() > 1){
            top = first.remove();
            second.add(top);
        }
        int res = first.remove();
        Queue<Integer> tmp = first;
        first= second; 
        second = tmp;
        return res;
        
    }
    
    /** Get the top element. */
    public int top() {
        return top;
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
