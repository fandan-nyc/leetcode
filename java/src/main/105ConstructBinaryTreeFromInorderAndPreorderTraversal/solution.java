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
    
    Map<Integer, Integer> inorderMap = new HashMap<Integer, Integer>();
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++){
            inorderMap.put(inorder[i],i);
        }
        if(preorder== null || preorder.length == 0){
            return null;
        }
        return helper(preorder, inorder, 0, 0, inorder.length-1);
    }
    
    private TreeNode helper(int[] preorder, int[] inorder, int preorderStart, int inorderStart, int inorderEnd){
        if(inorderStart > inorderEnd){
            return null;
        }
        TreeNode root =  new TreeNode(preorder[preorderStart]);
        if(inorderStart == inorderEnd){
            return root; 
        }
        int inorderLoc = inorderMap.get(preorder[preorderStart]);
        root.left =  helper(preorder, inorder, preorderStart+1, inorderStart, inorderLoc-1);
        root.right = helper(preorder, inorder, preorderStart+1+ (inorderLoc-inorderStart), inorderLoc+1, inorderEnd);
        return root;
    }
}
