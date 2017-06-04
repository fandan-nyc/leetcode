public class HitCounter {

    /** Initialize your data structure here. */
    // use buckets 
    int[] time;
    int[] count;
    public HitCounter() {
        time = new int[300];
        count = new int[300];
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        int curr = timestamp % 300;
        if(time[curr] != timestamp){
            time[curr] = timestamp;
            count[curr] = 1;
        }else{
            count[curr]++;
        }
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int total = 0;
        for(int i = 0; i < 300; i++){
            if(time[i] + 300 > timestamp){
                total += count[i];
            }
        }
        return total;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
