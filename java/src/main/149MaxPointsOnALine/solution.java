/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if(points == null || points.length <= 2){
            return points.length;
        }
        int max = 0;
        for(int i =0; i < points.length; i++){
            Map<Double, Integer> store = new HashMap<Double, Integer>();
            int samePoint = 0; 
            int vertical = 0;
            for(int j = 0; j < points.length; j++){
                if(i == j){
                    continue;
                }
                Point a = points[i];
                Point b = points[j];
                
                if(samePoint(a,b)){
                    samePoint ++;
                    vertical++;
                }else if(vertical(a, b)){
                    vertical++;
                }else{
                    double slop = slope(a, b);
                    if(store.containsKey(slop)){
                        store.put(slop, store.get(slop)+1);
                    }else{
                        store.put(slop, 2);
                    }
                }
            }
            for(double key: store.keySet()){
                max = Math.max(store.get(key)+samePoint , max);
            }
            max = Math.max(max, vertical+1);
        }
        return max;
    }
    
    private double slope(Point a, Point b){
        return (double)(a.y - b.y )/(double)(a.x-b.x);
    }
    
    private boolean vertical(Point a, Point b){
        return a.x == b.x;
    }
    private boolean samePoint(Point a, Point b){
        return a.x == b.x && a.y == b.y;
    }
}
