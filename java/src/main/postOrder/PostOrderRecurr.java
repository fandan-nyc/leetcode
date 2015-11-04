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
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null)
        {
            return new ArrayList<Integer>();
        }
        List<Integer> left = postorderTraversal(root.left);
        List<Integer> right = postorderTraversal(root.right);
        left.addAll(right);
        left.add(root.val);
        return left ;
    }
}
