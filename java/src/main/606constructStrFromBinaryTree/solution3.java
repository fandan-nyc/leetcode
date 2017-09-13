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
    public String tree2str(TreeNode t) {
        if(t == null){
            return "";
        }
        String tmp = helper(t);
        return tmp.substring(1, tmp.length()-1);
    }
    
    private String helper(TreeNode t){
        if(t.left == null && t.right == null){
            return "(" + t.val + ")";
        }
        StringBuilder sb = new StringBuilder("(");
        sb.append(t.val);
        sb.append(t.left == null ? "()" : helper(t.left));
        sb.append(t.right == null ? ""   : helper(t.right));
        sb.append(")");
        return sb.toString();
    }
}
