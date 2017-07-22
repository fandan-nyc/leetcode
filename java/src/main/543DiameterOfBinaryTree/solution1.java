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
    public int diameterOfBinaryTree(TreeNode root) {
        // must go through current root, compare 
        if(root == null){
            return 0;
        }
        int dia = depth(root.left) + 1 + depth(root.right)-1;
        return Math.max(Math.max(dia, diameterOfBinaryTree(root.left)), diameterOfBinaryTree(root.right));
    }
    
    private int depth(TreeNode root){
        if(root == null){
            return 0;
            
        }else{
            return 1 + Math.max(depth(root.left), depth(root.right));
        }
    }
}
