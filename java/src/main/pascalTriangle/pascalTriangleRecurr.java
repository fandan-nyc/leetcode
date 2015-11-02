public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(numRows == 0 )
        {
            return result ;
        }
        if(numRows == 1)
        {
            result.add(Arrays.asList(1));
            return result;
        }
        else 
        {
         List<List<Integer>> lastResult = generate(numRows -1);
         List<Integer> lastRow = lastResult.get(lastResult.size()-1);
         List<Integer> tmp = new ArrayList<Integer>();
         tmp.add(1);
         if(lastRow.size() > 1)
         {
            for(int i = 1; i < lastRow.size();i++)
            {
                tmp.add(lastRow.get(i) + lastRow.get(i-1));
            }
         }
         tmp.add(1);
         lastResult.add(tmp);
         return lastResult ;
        }
        
    }
}
