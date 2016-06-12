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
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftHeight = 1;
        int rightHeight = 1;
        TreeNode left = root.left;
        TreeNode right = root.right;
        while(left != null){
            leftHeight++;
            left = left.left;
        }
        while(right != null){
            rightHeight ++;
            right = right.right;
        }
        if(leftHeight == rightHeight){
            return (1<<leftHeight)-1;
        }    
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
