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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, 0, res);
        return res ;
    }
    
    private void helper(TreeNode root, int level, List<Integer> res){
        if(root == null){
            return;
        }
        if(level == res.size()){
            res.add(root.val);
        }else{
            res.set(level, Math.max(res.get(level), root.val));
        }
        helper(root.left, level+1, res);
        helper(root.right, level+1, res);
    }
}
