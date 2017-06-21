public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(numRows <= 0 ){
            return result;
        }
        result.add(Arrays.asList(1));
        int counter = 0;
        while( counter < numRows-1){
            List<Integer> tmp = new ArrayList(result.get(counter));
            for(int j = tmp.size()-1; j> 0; j --){
                tmp.set(j, tmp.get(j) + tmp.get(j-1));
            }
            tmp.add(1);
            result.add(tmp);
            counter++;
        }
        return result;
    }
}
