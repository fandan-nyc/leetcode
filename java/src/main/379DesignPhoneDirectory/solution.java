public class PhoneDirectory {

    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    Stack<Integer> recycled;
    int nextMax ;
    int max;
    Set<Integer> occupied;
    public PhoneDirectory(int maxNumbers) {
        nextMax = 0;
        max = maxNumbers;
        recycled = new Stack<Integer>();
        occupied = new HashSet<Integer>();
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if(recycled.empty() == false){
            int result = recycled.pop();
            occupied.add(result);
            return result;
        }else if(nextMax < max){
                occupied.add(nextMax);
                nextMax++;
                return nextMax -1;
        }
        return -1;
        
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        
        return number < 0 || number > max || !occupied.contains(number);
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        if(occupied.contains(number)){
            occupied.remove(number);
            recycled.push(number);
        }
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */
