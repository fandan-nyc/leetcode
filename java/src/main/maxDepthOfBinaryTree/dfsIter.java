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
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<Integer> depth = new Stack<>();
        int max = 0 ;
        stack.push(root);
        depth.push(1);
        while(stack.empty() == false){
            TreeNode tmpNode = stack.pop();
            int tmpDepth = depth.pop();
            max = Math.max(tmpDepth, max);
            if(tmpNode.right != null){
                stack.push(tmpNode.right);
                depth.push(tmpDepth+1);
            }
            if(tmpNode.left != null){
                stack.push(tmpNode.left);
                depth.push(tmpDepth+1);
            }
        }
        return max;
    }
}
