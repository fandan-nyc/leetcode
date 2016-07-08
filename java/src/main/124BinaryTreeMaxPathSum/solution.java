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
    private int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPathSumWithCurrentNode(root);
        return max;
    }
    
    private int maxPathSumWithCurrentNode(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftMax  = Math.max(maxPathSumWithCurrentNode(root.left), 0);
        int rightMax = Math.max(maxPathSumWithCurrentNode(root.right), 0);
        int currMax = (leftMax + rightMax + root.val);
        max = max > currMax ? max: currMax;
        return Math.max(leftMax, rightMax) + root.val;
    }
    
}
