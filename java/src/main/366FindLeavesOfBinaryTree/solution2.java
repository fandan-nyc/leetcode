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
        while(root != null){
            List<Integer> tmp = new ArrayList<>();
            root = helper(root, tmp);
            result.add(tmp);
        }
        return result;
    }
    
    private TreeNode helper(TreeNode root, List<Integer> result){
        if(root == null){
            return null;
        }else if( root.left == null && root.right == null){
            result.add(root.val);
            return null;
        }else{
            root.left = helper(root.left, result);
            root.right = helper(root.right, result);
            return root;
        }
    }
}
