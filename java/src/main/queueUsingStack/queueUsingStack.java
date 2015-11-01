class MyQueue {
    private Stack<Integer> one = new Stack<Integer>();
    private Stack<Integer> two = new Stack<Integer>();
    
    // Push element x to the back of queue.
    public void push(int x) {
            one.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(two.isEmpty())
        {
           moveOneToTwo(one, two);
        }
        two.pop();
    }

    // Get the front element.
    public int peek() {
        if(two.isEmpty())
        {
             moveOneToTwo(one, two);
        }
        return two.peek();
        
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return one.isEmpty() && two.isEmpty();
    }
    
    private <T> void moveOneToTwo(Stack<T> one, Stack<T> two)
    {
         while(!one.isEmpty())
        {
            two.push(one.pop());
        }
    }
}
