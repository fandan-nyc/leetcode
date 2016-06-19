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
    public void flatten(TreeNode root) {
        if(root == null){
            return ;
        }
        flatten(root.left);
        flatten(root.right);
        if(root.left != null){
            TreeNode tmp = root.left;
            while(tmp.right != null){
                tmp = tmp.right;
            }
            tmp.right = root.right;
            root.right = root.left;
            root.left = null;
        }
    }
}
