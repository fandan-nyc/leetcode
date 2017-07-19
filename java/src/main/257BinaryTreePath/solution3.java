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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        backTracking(root, res, new StringBuilder());
        return res;
    }
    
    private void backTracking(TreeNode root, List<String> res, StringBuilder sb){
        if(root == null){
            return ;
        }
        if(root.left == null && root.right == null){
            res.add(sb.toString() + root.val);
            return;
        }
        int len = sb.length();
        sb.append(root.val + "->");
        backTracking(root.left, res, sb);
        backTracking(root.right, res, sb);
        sb.setLength(len);
        return;
    }
}
