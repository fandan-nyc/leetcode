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
    public void recoverTree(TreeNode root) {
        TreeNode prev = null, first = null, second = null;
        Stack<TreeNode> stack = new Stack<TreeNode>(); 
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            TreeNode curr = stack.pop();
            // this is the diff between in-order traversal and the recovery
            if(prev != null){
                if(prev.val > curr.val){
                    if(first == null){
                        first = prev;
                    }
                    second = curr;
                }
            }
            // end of the diff
           prev = curr;
           root = curr.right;
        }
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }
}
