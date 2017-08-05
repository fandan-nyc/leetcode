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
        int rootVal = nums[nums.length/2];
        TreeNode root = new TreeNode(rootVal);
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, nums.length/2));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums, nums.length/2+1, nums.length));
        return root;
    }
}
