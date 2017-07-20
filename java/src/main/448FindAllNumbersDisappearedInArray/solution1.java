public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // with space
        boolean[] occupied = new boolean[nums.length+1];
        for(int i: nums){
            occupied[i] = true;
        }
        List<Integer> result = new ArrayList<Integer>();
        for(int i = 1; i < occupied.length; i ++){
            if(occupied[i] == false){
                result.add(i);
            }
        }
        return result;
    }
}
