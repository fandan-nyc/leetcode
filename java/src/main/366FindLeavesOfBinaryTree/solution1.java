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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        height(root, result);
        return result;
    }
    
    private int height(TreeNode root, List<List<Integer>> result){
        if(root == null){
            return -1;
        }
        int height = 1 + Math.max(height(root.left, result), height(root.right, result));
        if(height +1 > result.size()){
            result.add(new ArrayList<Integer>());
        }
        result.get(height).add(root.val);
        return height;
    }
    
    
}
