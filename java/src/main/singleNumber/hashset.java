public class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> result = new HashSet<Integer>();
        for(int i: nums){
            if(result.contains(i)){
                result.remove(i);
            }else{
                result.add(i);
            }
        }
        assert result.size() == 1;
        return result.iterator().next();
    }
}
