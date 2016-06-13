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
    
    private void helper(TreeNode root, int sum, List<List<Integer>> result, List<Integer>curr){
        if(root == null ){
            return;
        }
        if(root.left == null && root.right == null && sum ==  root.val){
            curr.add(root.val);
            result.add(curr);
            return;
        }
        curr.add(root.val);
        helper(root.left,  sum - root.val, result, new ArrayList<Integer>(curr));
        helper(root.right, sum - root.val, result, new ArrayList<Integer>(curr));
    }
}
