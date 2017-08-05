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
    int res= 0;
    int high = 0;
    public int findBottomLeftValue(TreeNode root) {
        //recursive
        helper(root,1);
        return res;
    }
    
    private void helper(TreeNode root, int height){
        if(height > high){
            high = height;
            res = root.val;
        }
        if(root.left != null){
            helper(root.left, height+1);
        }
        if(root.right != null){
            helper(root.right, height+1);
        }
    }
}
