/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res.get(k-1);
    }
    
    private void helper(TreeNode root, List<Integer> res){
        if(root == null){
            return;
        }
        helper(root.left, res);
        res.add(root.val);
        helper(root.right, res);
    }
}

