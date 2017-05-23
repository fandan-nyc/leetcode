public class MovingAverage {

    private LinkedList<Integer> mostRecent;
    private Integer sum = null;
    private int count;
    private int size;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
         this.count = 0;
         this.size = size;
         sum = 0;
         mostRecent = new LinkedList<Integer>();
    }
    
    public double next(int val) {
        mostRecent.add(val);
        if(count < size){
            count ++;
            sum += val;
        }else {
            sum += val;
            sum -= mostRecent.remove();
        }
        return (double)sum / count;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
