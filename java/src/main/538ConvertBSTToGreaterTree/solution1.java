/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        convert(root);
        return root;
    }
    
    private void convert(TreeNode root){
        if(root == null){
            return;
        }
        convert(root.right);
        root.val += sum;
        sum = root.val;
        convert(root.left);
    }
}
