public class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int max = 1;
        for(int i: nums){
            if(!map.containsKey(i)){
                int left =  map.containsKey(i-1) ? map.get(i-1) : 0;
                int right = map.containsKey(i+1) ? map.get(i+1): 0;
                int total = 1+left+right;
                map.put(i, total);
                map.put(i-left, total);
                map.put(i+right, total);
                max =  max > total ? max: total;
            }
        }
        return max;
    }
}
