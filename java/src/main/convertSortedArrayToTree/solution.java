/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }
        return helper(nums, 0, nums.length-1);
        
    }
    
    private TreeNode helper(int[] nums, int start, int end){
        if(start > end){
            return null;
        }
        int middle = (start + end) /2 ; 
        TreeNode x = new TreeNode(nums[middle]);
        x.left= helper(nums, start, middle -1);
        x.right = helper(nums, middle+1, end);
        return x;
    }
}
