class Solution {
    public int[] findErrorNums(int[] nums) {
        int sum  = 0 ;
        int expected = (1+ nums.length)* nums.length /2;
        Set<Integer> visited = new HashSet<>();
        int[] res = new int[2];
        for(int i: nums){
            if(visited.add(i) == false){
                res[0] = i;
            }
            sum += i;
        }
        res[1] = expected - ( sum - res[0]);
        return res;
    }
}
