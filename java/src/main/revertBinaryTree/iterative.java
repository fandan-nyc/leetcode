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
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return root;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        TreeNode curr;
        TreeNode tmp ;
        while(!queue.isEmpty()){
             curr =  queue.remove();
             tmp = curr.left;
             curr.left = curr.right;
             curr.right = tmp;
             if(curr.left != null)
                queue.add(curr.left);
            if(curr.right != null)
                queue.add(curr.right);
        }
        return root;
    }
}
