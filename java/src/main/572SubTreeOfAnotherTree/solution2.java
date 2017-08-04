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
    public boolean isSubtree(TreeNode a, TreeNode b) {
        return traverse(a,b);
    }
    
    private boolean equals(TreeNode a, TreeNode b){
        if(a == null && b == null){
            return true;
        }else if(a == null || b == null){
            return false;
            
        }else{
            return a.val == b.val && equals(a.left, b.left) && equals(a.right, b.right);
        }
    }
    
    private boolean traverse(TreeNode a, TreeNode b){
        return a != null && (equals(a, b) || traverse(a.left, b) || traverse(a.right, b));
    }
}
