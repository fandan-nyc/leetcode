i/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class SummaryRanges {

    /** Initialize your data structure here. */
    private List<Interval> store ; 
    public SummaryRanges() {
        store = new ArrayList<Interval>();
    }
    
    public void addNum(int val) {
        Interval inter = new Interval(val, val);
        int pos = search(inter);
        insertAndMerge(inter, pos);
    }
    
    public List<Interval> getIntervals() {
        return store;
    }
    
    private int search(Interval input){
        int start = 0;
        int end = store.size()-1;
        while(start <= end){
            int middle = start + (end - start)/2;
            if(store.get(middle).start == input.start){
                return middle;
            }else if(store.get(middle).start > input.start){
                end = middle-1;
            }else {
                start = middle +1;
            }
        }
        return start;
    }
    
    private void merge(int a, int b){
        if(a < 0 || b > store.size() -1){
            return ;
        }
        Interval aInterval = store.get(a);
        Interval bInterval = store.get(b);
        if(aInterval.end +1 >= bInterval.start){
            store.get(a).start = Math.min(aInterval.start, bInterval.start);
            store.get(a).end =   Math.max(aInterval.end,   bInterval.end);
            store.remove(b);
        }
    }
    
    private void insertAndMerge(Interval input, int pos){
        store.add(pos, input);
        merge(pos, pos+1);
        merge(pos-1, pos);
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */
