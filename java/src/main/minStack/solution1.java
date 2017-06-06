public class MinStack {

    /** initialize your data structure here. */
    
    private long min ;
    Stack<Long> data ;
    public MinStack() {
        data = new Stack<>();
        min = 0L;
    }
    
    public void push(int x) {
        if(data.empty()){
            data.push(0L);
            min = (long)x;
        }else{
            data.push(x-min);
            min = x < min ? x: min;
        }
    }
    
    public void pop() {
        if(data.empty()){
            return;
        }
        long curr = data.pop();
        if( curr < 0){
            min = min - curr;
        }
    }
    
    public int top() {
        return data.peek() > 0L ? (int) (min + (long)data.peek()) : (int)min;  
    }
    
    public int getMin() {
        return (int)min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
