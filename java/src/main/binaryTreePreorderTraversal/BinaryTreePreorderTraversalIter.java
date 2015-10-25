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
        List<Integer> result = new ArrayList<Integer>();
        if(root == null)
        {
            return result;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty())
        {
            TreeNode tmp = stack.pop();
            result.add(tmp.val);
            if(tmp.right != null)
            {
                stack.push(tmp.right);
            }
            if(tmp.left != null)
            {
                stack.push(tmp.left);
            }
        }
        return result ;
    }
}
