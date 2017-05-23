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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if(root == null){
            return result;
        }
        result.add(root.val);
        getLeftBound(root.left,  result);
        getLeaf(root.left,  result);
        getLeaf(root.right, result);
        getRightBound(root.right, result);
        return result;
    }
    
    private void getLeaf(TreeNode root, List<Integer> output){
        if(root == null) {
            return;
        }else if(root.left == null && root.right == null){
            output.add(root.val);
            return;
        }else {
            getLeaf(root.left, output);
            getLeaf(root.right, output);
        }
    }
    
    private void getLeftBound(TreeNode root, List<Integer> output){
        if(root == null || (root.left == null && root.right == null)){
            return;
        }
        output.add(root.val);
        if(root.left != null){
            getLeftBound(root.left, output);
        }else{
            getLeftBound(root.right, output);
        }
    }
    
    private void getRightBound(TreeNode root, List<Integer> output){
        if(root == null || (root.left == null && root.right == null)){
            return;
        }
        if(root.right != null){
            getRightBound(root.right, output);
        }else{
            getRightBound(root.left, output);
        }
        output.add(root.val);
    }
}
