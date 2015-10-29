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
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
        {
            return true;
        }
        return symmetricSubTree(root.left, root.right);
       
    }
    private boolean symmetricSubTree(TreeNode left, TreeNode right)
    {
        if(left == null && right == null)
        {
            return true;
        }
        else if( left == null || right == null)
        {
            return false;
        }
        return (left.val == right.val) && symmetricSubTree(left.right, right.left) && symmetricSubTree( left.left, right.right);
    }
}
