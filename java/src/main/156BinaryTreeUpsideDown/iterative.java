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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
       TreeNode current = root; 
       TreeNode prev = null;
       TreeNode tmp = null;
       TreeNode next = null;
       while(current != null){
           next = current.left; 
           current.left = tmp;
           tmp = current.right;
           current.right = prev;
           prev = current;
           current = next;
       }
       return prev;
    }
}
