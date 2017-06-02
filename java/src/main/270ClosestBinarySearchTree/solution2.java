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
    public int closestValue(TreeNode root, double target) {
       int result = root.val;
       while(root != null){
           if( Math.abs(root.val - target) < Math.abs(result - target)){
               result = root.val;
           }
           root = root.val < target ? root.right: root.left;
       }
       return result;
    }
}
