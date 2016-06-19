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
    public void flatten(TreeNode root) {
       Stack<TreeNode> stack = new Stack<TreeNode>();
       while(root !=null || !stack.isEmpty()){
           if(root.left != null){
               if(root.right != null){
                   stack.push(root.right);
               }
               root.right = root.left;
               root.left = null;
               root=root.right;
           }else{
               if(root.right  ==  null && stack.isEmpty() == false){
                   root.right = stack.pop();
               }
               root = root.right;
           }
       }
    }
}
