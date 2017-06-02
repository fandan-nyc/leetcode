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
        double diff = Math.abs(target - root.val);
        int result = root.val;
        if(root.left != null){
            int tmp = closestValue(root.left, target);
            result = Math.abs(target - tmp) > diff ? result: tmp;
        }
        if(root.right != null){
            int tmp = closestValue(root.right, target);
            result = Math.abs(target - tmp) > diff ? result: tmp;       
        }
        return result;
    }
}
