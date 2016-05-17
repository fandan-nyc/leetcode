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
    public int rob(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftLeft = root.left == null ? 0: rob(root.left.left);
        int leftRight = root.left == null ? 0: rob(root.left.right);
        int rightLeft = root.right == null ? 0: rob(root.right.left);
        int rightRight = root.right == null ? 0: rob(root.right.right);
        int left = root.left == null ? 0: rob(root.left);
        int right = root.right == null ? 0: rob(root.right);
        return Math.max(left+right, root.val + leftLeft + leftRight + rightLeft + rightRight);
    }
}
