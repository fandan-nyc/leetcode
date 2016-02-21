class MinStack {
    
    Stack<Integer> record = new Stack<Integer>();
    Stack<Integer> minRecord = new Stack<Integer>();
    
    public void push(int x) {
        record.push(x);
        if(minRecord.isEmpty()){
            minRecord.push(x);
        }else{
            minRecord.push(Math.min(x,minRecord.peek()));
        }
    }

    public void pop() {
        record.pop();
        minRecord.pop();
    }

    public int top() {
        return record.peek();
    }

    public int getMin() {
        return minRecord.peek();
    }
}

