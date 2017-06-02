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
    public boolean canAttendMeetings(Interval[] intervals) {
        if(intervals == null || intervals.length <= 1){
            return true;
        }
        quickSort(intervals, 0, intervals.length-1);
        for(Interval i: intervals){
            System.out.println("start:" + i.start + ", end" + i.end);
        }
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i].start < intervals[i-1].end){
                return false;
            }
        }
        return true;
        
    }
    
    private void quickSort(Interval[] intervals, int low, int high){
        if(low <= high){
            Interval pivot = intervals[low];
            int next = high+1;
            int pos = low+1;
            while(pos < next){
                if(intervals[pos].start > pivot.start){
                    next--;
                    swap(intervals, pos, next);
                }
                else{ 
                    pos++;
                }
            }
            swap(intervals, low, next-1);
            quickSort(intervals, low, next-2);
            quickSort(intervals, next, high);
        }
    }
    
    private void swap(Interval[] intervals, int a, int b){
        Interval tmp = intervals[a];
        intervals[a] = intervals[b];
        intervals[b] = tmp;
    }
    
}
