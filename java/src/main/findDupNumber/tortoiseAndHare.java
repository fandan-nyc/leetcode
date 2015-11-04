public class Solution {
    public int findDuplicate(int[] nums) {
        // nums cannot be null; nums should have at least two, in which both should be 1. as we have array 
        // length of n, and all numbers should be 1 .. n - 1
        int slow = nums[0];
        int fast = nums[nums[0]];
        while(slow != fast)
        {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        int tmp = nums[0];
        slow = nums[slow];
        while(tmp != slow)
        {
            tmp= nums[tmp];
            slow = nums[slow];
        };
        return slow;
    }
}
