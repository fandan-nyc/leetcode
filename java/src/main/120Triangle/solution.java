public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0){
            return 0;
        }
        int index = triangle.size()-1;
        while(index > 0){
            for(int i = 0; i < triangle.get(index-1).size();i++){
                int tmp = triangle.get(index-1).get(i);
                int lowerLeft = triangle.get(index).get(i);
                int lowerRight= triangle.get(index).get(i+1); 
                triangle.get(index-1).set(i, tmp + Math.min(lowerLeft, lowerRight));
            }
            --index;
        }
        return triangle.get(0).get(0);
    }
}
