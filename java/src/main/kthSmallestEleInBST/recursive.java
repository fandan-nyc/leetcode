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
    public int kthSmallest(TreeNode root, int k) {
        int left = totalNodes(root.left) ;
        if(k == left +1){
            return root.val;
        }
        else if( k <= left ){
            return kthSmallest(root.left, k);
        }
        else{
            return kthSmallest(root.right, k - left-1);
        }
    }
    
    public int totalNodes(TreeNode root){
        if(root == null){
            return 0;
        }
        return totalNodes(root.left) + totalNodes(root.right) + 1;
    }
}
