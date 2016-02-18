public class Solution {
    public List<List<Integer>> generate(int numRows) {
        LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
        while(numRows-- > 0){
            addOneLevel(result);
        }
        return result;
    }
    
    private void addOneLevel(LinkedList<List<Integer>> result){
       if(result.isEmpty()){
           result.add(Arrays.asList(1));
       }
       else{
           List<Integer> tmp = new LinkedList<Integer>();
           tmp.add(1);
           if(result.getLast().size() >= 2){
               for(int i = 0; i < result.getLast().size()-1; i++){
                   tmp.add(result.getLast().get(i) + result.getLast().get(i+1));
               }
           }
           tmp.add(1);
           result.add(tmp);
       }
    }
}
