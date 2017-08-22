class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int sum = 0; 
        int max = 0;
        Map<Integer, Integer> data = new HashMap<>();
        data.put(0, -1);
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(data.containsKey(sum - k)){
                max = Math.max(max, i - data.get(sum-k));
            }
            if(!data.containsKey(sum)){
                data.put(sum, i);
            }
        }
        return max;   
    }
}
