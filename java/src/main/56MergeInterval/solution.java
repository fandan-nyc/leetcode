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
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<Interval>();
        if(intervals == null || intervals.size()  == 0){
            return result;
        }
        quickSort(intervals, 0, intervals.size()-1);
        Interval tmp = intervals.get(0);
        for(int i = 1; i < intervals.size(); i++){
            Interval curr = intervals.get(i);
            if(tmp.end >= curr.start){
                tmp = merge(curr, tmp);
            }else{
                result.add(new Interval(tmp.start, tmp.end));
                tmp = curr;
            }
        }
        result.add(new Interval(tmp.start, tmp.end));
        return result;
    }
    
    private void quickSort(List<Interval> intervals, int start, int end){
        if(start >= end){
            return;
        }
        Interval pivot = intervals.get(start);
        int next = start+1;
        for(int i = start+1; i <= end; i++){
            Interval curr = intervals.get(i);
            if(curr.start < pivot.start){
                swap(intervals, i, next);
                next++;
            }
        }
        swap(intervals, start, next-1);
        quickSort(intervals, start, next-2);
        quickSort(intervals, next, end);
    }
    
    private void swap(List<Interval> intervals, int a, int b){
        Interval tmpA = intervals.get(a);
        Interval tmpB = intervals.get(b);
        intervals.set(a, tmpB);
        intervals.set(b, tmpA);
    }
    
    private Interval merge(Interval a, Interval b){
        return new Interval(a.start < b.start ? a.start: b.start, a.end > b.end ? a.end: b.end);
    }
}
