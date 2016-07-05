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
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        List<Integer> result = new ArrayList<Integer>();
        preorderTraversal( root, result);
        int tmp = result.get(0);
        for(int i = 1; i < result.size(); i++){
            if(tmp >= result.get(i)){
                return false;
            }
            tmp = result.get(i);
        }
        return true;
    }
    
    private void preorderTraversal(TreeNode root, List<Integer> result){
        if(root == null){
            return;
        }
        else{
            preorderTraversal( root.left,  result);
            result.add(root.val);
            preorderTraversal( root.right, result);
        }
    }
}
