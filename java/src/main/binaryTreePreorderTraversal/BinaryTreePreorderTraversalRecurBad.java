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
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null)
        {
            return new ArrayList<Integer>();
        }
        else
        {
            List<Integer> left = preorderTraversal(root.left);
            left.add(0,root.val);
            if(preorderTraversal(root.right) != null)
            {
            left.addAll(preorderTraversal(root.right));
            }
            return left;
        }
    }
}
