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
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
        {
            return true;
        }
       
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root.left);
        stack.push(root.right);
        while(!stack.isEmpty())
        {
            TreeNode left = stack.pop();
            TreeNode right =  stack.pop();
            if(left == null && right == null )
            {
                continue;
            }
            else if (left == null || right == null)
            {
                return false;
            } 
            else if(left.val != right.val)
            {
                return false;
            }
            stack.push(left.right);
            stack.push(right.left);
            stack.push(left.left);
            stack.push(right.right);
        }
        return true;
    }
}
