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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || inorder.length == 0){
            return null;
        }
        return helper(inorder, postorder, 0, inorder.length-1, postorder.length-1);
    }
    
    private TreeNode helper(int[] inorder, int[] postorder, int inorderStart, int inorderEnd, int postorderEnd){
        // postOrderEnd is the root; 
        if(inorderStart > inorderEnd){
            return null;
        }
        TreeNode root = new TreeNode(postorder[postorderEnd]);
        if(inorderStart == inorderEnd){
            return root;
        }
        int loc = 0;
        for(int i = inorderStart; i <= inorderEnd; i++){
            if(inorder[i] == postorder[postorderEnd]){
                loc = i;
                break;
            }
        }
        // inorder left: start -> loc-1
        // inorder right: loc+1 -> end
        root.left =  helper(inorder, postorder, inorderStart, loc-1, postorderEnd -(inorderEnd-loc) -1);
        root.right = helper(inorder, postorder, loc+1, inorderEnd, postorderEnd-1);
        return root;
    }
}
