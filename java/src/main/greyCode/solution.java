public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result =  new ArrayList<Integer>();
        result.add(0);
        if(n == 0){
            return result;
        }
        int bit ; 
        for(int i = 0; i < n; i ++){
            bit = 1<<i;
            for(int j= result.size()-1;j>=0; j--){
                result.add(result.get(j)+bit);
            }
        }
        return result;
    }
}
