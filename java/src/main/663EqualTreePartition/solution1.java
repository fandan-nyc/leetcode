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
    public boolean checkEqualTree(TreeNode root) {
        if(root == null){
            return false;
        }
        int total = sumTree(root);
        if(total %2 != 0){
            return false;
        }
        int expected = total /2 ; 
        return dfs(root, expected);
    }
    
    private boolean dfs(TreeNode root, int expected ){
        if(root == null){
            return false;
        }
        if(root.left != null && sumTree(root.left) == expected){
            return true;
        }
        if(root.right != null && sumTree(root.right) == expected){
            return true;
        }
        return dfs(root.left, expected) || dfs(root.right, expected);
    }
    
    private int sumTree(TreeNode root){
        if(root == null){
            return 0;
        }
        return root.val + sumTree(root.left) + sumTree(root.right);
    }
}
