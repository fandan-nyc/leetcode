/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if(intervals == null || intervals.size() == 0){
            return Arrays.asList(newInterval);
        }
        if(newInterval.start >= intervals.get(intervals.size()-1).start){
            intervals.add(newInterval);
        }else{
            for(int i = 0; i < intervals.size(); i ++){
                if(newInterval.start < intervals.get(i).start){
                    intervals.add(i, newInterval);
                    break;
                }
            }
        }
        return mergeInterval(intervals);
    }
    
    private List<Interval> mergeInterval(List<Interval> intervals){
        Interval tmp = intervals.get(0);
        List<Interval> result = new ArrayList<Interval>();
        for(int i = 1; i < intervals.size(); i++){
            Interval curr = intervals.get(i);
            if(tmp.end < curr.start){
                result.add(tmp);
                tmp = curr;
            }else{
                tmp = merge(curr, tmp);
            }
        }
        result.add(tmp);
        return result;
    }
    
    private Interval merge(Interval a, Interval b){
        return new Interval(a.start < b.start ? a.start: b.start, a.end< b.end? b.end: a.end);
    }
}
