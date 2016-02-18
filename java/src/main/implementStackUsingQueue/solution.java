class MyStack {
    
    private Queue<Integer> first = new LinkedList<Integer>(); 
    private Queue<Integer> second = new LinkedList<Integer>(); 
    
    // Push element x onto stack.
    public void push(int x) {
        if(first.isEmpty()){
            first.add(x);
        }else{
            second.add(first.poll());
            first.add(x);
        }
        
    }

    // Removes the element on top of the stack.
    public void pop() {
        first.poll();
        while(second.size() > 1){
            first.add(second.poll());
        }
        Queue<Integer> tmp = second;
        second = first; 
        first = tmp;
    }

    // Get the top element.
    public int top() {
        return first.peek();
        
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return first.isEmpty() && second.isEmpty();
        
    }
}
