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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        Queue<TreeNode> nodes =  new LinkedList<TreeNode>(); 
        Queue<Integer> subSum = new LinkedList<Integer>();
        nodes.add(root);
        subSum.add(sum - root.val);
        while(!nodes.isEmpty()){
            TreeNode tmp = nodes.poll();
            int tmpSum = subSum.poll();
            if(tmpSum == 0 && tmp.left == null && tmp.right == null){
                return true;
            }else {
                if(tmp.left != null) {
                    nodes.add(tmp.left);
                    subSum.add(tmpSum - tmp.left.val);
                }
                if(tmp.right != null){
                    nodes.add(tmp.right);
                    subSum.add(tmpSum - tmp.right.val);
                }
            }
        }
        return false;
    }
}
