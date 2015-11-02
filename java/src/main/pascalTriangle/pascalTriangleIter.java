public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(numRows == 0 )
        {
            return result ;
        }
        List<Integer> lastRow = Arrays.asList(1);
        result.add(lastRow);
        if(numRows ==  1)
        {
            return result ;
        }
        for(int i = 2; i <= numRows; i++)
        {
           List<Integer> tmp =  new ArrayList<Integer>();
           tmp.add(1);
           for( int j = 0; lastRow.size() >= 2 && j < lastRow.size()-1;j++)
           {
              tmp.add(lastRow.get(j) + lastRow.get(j+1));
           }
           tmp.add(1);
           result.add(tmp);
           lastRow = tmp ;
         }
        return result ;

    }
}
