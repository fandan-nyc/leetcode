public class MyQueue {

    private Stack<Integer> first;
    private Stack<Integer> second;
    /** Initialize your data structure here. */
    public MyQueue() {
        first  = new Stack<Integer>();
        second = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        if(!first.empty()){
            second.push(x);
        }
        else{
            first.push(x);
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int result = first.pop();
        if(second.empty()){
            return result;
        }
        while(second.size() > 1){
            first.push(second.pop());
        }
        int tmp = second.pop();
        while(first.empty() == false){
            second.push(first.pop());
        }
        first.push(tmp);
        return result;
    }
    
    /** Get the front element. */
    public int peek() {
        return first.peek();
        
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return first.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
