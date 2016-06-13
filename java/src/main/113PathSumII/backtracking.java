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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        helper(root, sum, result, new ArrayList<Integer>());
        return result;
    }
    
    private void helper(TreeNode root, int sum, List<List<Integer>> result, List<Integer>tmp){
        if(root == null){
            return;
        }
        tmp.add(root.val);
        if(root.left == null && root.right == null && root.val == sum){
            result.add(new ArrayList<Integer>(tmp));
            tmp.remove(tmp.size()-1);
            return;
        }
        helper(root.left, sum-root.val, result, tmp);
        helper(root.right, sum-root.val, result, tmp);
        tmp.remove(tmp.size()-1);
    }
}
