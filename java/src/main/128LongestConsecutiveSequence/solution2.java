class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for(int i: nums){
            set.add(i);
        }
        int longest = 1;
        for(int i: set){
            if(!set.contains(i-1)){
                int y = i;
                while(set.contains(y+1)){
                    y = y+1;
                }
                longest =  Math.max(longest, y-i+1);
            }
        }
        return longest;
    }
}
