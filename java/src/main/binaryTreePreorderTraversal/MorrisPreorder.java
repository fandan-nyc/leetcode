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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        TreeNode node = root; 
        while(node != null){
            if(node.left == null){
                result.add(node.val);
                node = node.right;
            }
            else{
                TreeNode curr = node.left; 
                while(curr.right != null && curr.right != node){
                    curr = curr.right;
                }
                if(curr.right == null){
                    result.add(node.val);
                    curr.right = node; 
                    node = node.left;
                }
                else{
                    curr.right = null; 
                    node = node.right;
                }
            }
        }
        return result;
    }
}
