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
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int depth = 0;
        while(!queue.isEmpty()){
            int lens = queue.size();
            depth++;
            while(lens > 0){
                TreeNode tmp = queue.poll();
                if(tmp.left == null && tmp.right == null){
                    return depth;
                }
                if (tmp.left != null){
                    queue.add(tmp.left);
                }
                if (tmp.right != null){
                    queue.add(tmp.right);
                }
                lens --;
            }
        }
        return depth;
    }
}
