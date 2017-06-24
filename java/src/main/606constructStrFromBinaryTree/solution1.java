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
    public String tree2str(TreeNode t) {
        if(t == null){
            return "";
        }else{
            StringBuilder sb = new StringBuilder();
            sb.append(t.val);
            if(t.left == null && t.right == null){
                return sb.toString();
            }
            else {
                sb.append("(");
                sb.append(tree2str(t.left));
                sb.append(")");
                if(t.right != null){
                     sb.append("(");
                    sb.append(tree2str(t.right));
                    sb.append(")");
                }
            }
            return sb.toString();
        }
    }
}
