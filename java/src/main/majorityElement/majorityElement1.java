public class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> resultMap = new HashMap<Integer, Integer>();
        for(int i : nums)
        {
            resultMap.put(i, resultMap.containsKey(i) ? resultMap.get(i) + 1: 1);
        }
        int result = 0;
        int max = 0;
        for(Map.Entry<Integer, Integer> i : resultMap.entrySet())
        {
            if(i.getValue() > max)
            {
                max = i.getValue(); 
                result = i.getKey();
            }
        }
        return result ; 
    }
}
