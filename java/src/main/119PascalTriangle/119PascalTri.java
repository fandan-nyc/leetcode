public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<Integer>();
        while(rowIndex >= 0)
        {
            for(int i = 0; i < result.size() -1; i ++)
            {
               result.set(i, result.get(i) + result.get(i+1));
            }
            result.add(0,1);
            rowIndex --;
        }
        return result ; 
    }
}
