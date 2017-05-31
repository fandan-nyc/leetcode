public class Solution {
    public List<String> findStrobogrammatic(int n) {
        return helper(n, n);
        
    }
    
     private List<String> helper(int n, int max) {
        if(n == 0){
            return new ArrayList<String>(Arrays.asList(""));
        }else if(n == 1){
            return new ArrayList<>(Arrays.asList("1", "8","0"));
        }else {
            List<String> tmp = helper(n-2, max);
            List<String> result = new ArrayList<>();
            for(String i: tmp){
                result.add("1" + i +"1");
                result.add("8" + i +"8");
                result.add("6" + i +"9");
                result.add("9" + i +"6");
                if(n < max){
                     result.add("0" + i +"0");
                }
            }
            return result;
        }
    }
}
