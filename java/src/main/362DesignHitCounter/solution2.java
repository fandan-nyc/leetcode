public class HitCounter {

    /** Initialize your data structure here. */
    Queue<Integer> data ;
    public HitCounter() {
        data = new LinkedList<>();
        
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        data.add(timestamp);
        while(data.peek()   <= timestamp - 300){
            data.remove();
        }
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while(data.peek() != null && data.peek() <= timestamp - 300){
            data.remove();
        }
        return data.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
