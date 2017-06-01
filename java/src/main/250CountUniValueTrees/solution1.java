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
    public int countUnivalSubtrees(TreeNode root) {
       int[] data = new int[1];
       isUniTree(root, data);
       return data[0];
    }
    
    private boolean isUniTree(TreeNode root, int[] data){
        if(root == null ){
            return true;
        }else{
             boolean left =  isUniTree(root.left, data);
             boolean right = isUniTree(root.right, data);
            if(left && right){
                if(root.left != null && root.val != root.left.val){
                   return false;
                }
                if(root.right != null && root.val != root.right.val){
                    return false;
                }
            
                data[0] ++;
                return true;
            }
            return false;
        }
    }
}
