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
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }else if( Math.abs(height(root.left) - height(root.right)) >= 2){
            return false;
        }else{
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }
    
    private int height(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max( height(root.left), height(root.right)) + 1;
    }
}
