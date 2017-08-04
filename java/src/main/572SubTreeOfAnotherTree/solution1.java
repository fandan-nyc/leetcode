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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        String first = preorder(s, true);
        String second = preorder(t, true);
        return first.indexOf(second) >= 0;
    }
    
    private String preorder(TreeNode s, boolean left){
        if(s == null){
            return left ? "lnull" : "rnull";
        }
        return "#"+s.val + " " + preorder(s.left, true) + " " + preorder(s.right, false);
    }
}
